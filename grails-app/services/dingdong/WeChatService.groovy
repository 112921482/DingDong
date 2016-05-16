package dingdong

import com.budjb.httprequests.HttpRequest
import com.budjb.httprequests.jersey1.JerseyHttpClientFactory
import dingdong.customer.WeChatUser
import grails.plugin.cache.CachePut
import grails.plugin.cache.Cacheable
import grails.transaction.Transactional

@Transactional
class WeChatService {

    def grailsApplication

    /**
     * 获取微信access_token
     * @return
     */
    @Cacheable(value = "WeChatToken", key = "1000", condition = "#getTime > 0")
    Map getWeChatToken() {
        log.info((new Date()).toString() + "-从微信请求token")
        def client = new JerseyHttpClientFactory().createHttpClient()
        def request = new HttpRequest()
                .setUri("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${grailsApplication.config.weixin?.appId}&secret=${grailsApplication.config.weixin?.appSecret}")
                .setAccept("application/json")
        def response = client.get(request)
        def dataMap = response.getEntity(Map)
        if (dataMap.get("errcode")) {
            dataMap.put("getTime", 0)
        } else {
            dataMap.put("getTime", new Date().getTime())
        }
        return dataMap
    }

    /**
     * 更新微信access_token
     * @return
     */
    @CachePut(value = "WeChatToken", key = "1000")
    Map updateWeChatToken() {
        log.info((new Date()).toString() + "-从微信更新token")
        def client = new JerseyHttpClientFactory().createHttpClient()
        def request = new HttpRequest()
                .setUri("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${grailsApplication.config.weixin?.appId}&secret=${grailsApplication.config.weixin?.appSecret}")
                .setAccept('application/json')
        def response = client.get(request)
        def dataMap = response.getEntity(Map)
        dataMap.put("getTime", new Date().getTime())
        return dataMap
    }

    /**
     * 验证微信signature
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    def validateSignature(String signature, String timestamp, String nonce) {
        log.info((new Date()).toString() + "-微信接口校验")
        String token = grailsApplication.config.weixin?.token
        def paramsArray = [token, timestamp, nonce].sort()
        StringBuilder sb = new StringBuilder()
        paramsArray.each {
            sb.append(it)
        }
        return sb.encodeAsSHA1().equals(signature)
    }

    /**
     * 自定义菜单
     */
    def diyMenu() {
        log.info((new Date()).toString() + "-修改微信自定义菜单")
        def client = new JerseyHttpClientFactory().createHttpClient()
        def inputStream = new FileInputStream(new File("${grailsApplication.config.picSavePath}/WeChatMenu.txt"))
        def response = client.post(inputStream) {
            uri = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=${getWeChatToken().get("access_token")}"
            contentType = "application/json"
        }
        def dataMap = response.getEntity(Map)
        if (dataMap.get("errcode") == 0) {
            log.info((new Date()).toString() + "-修改微信自定义菜单成功！")
            return true
        } else {
            log.info((new Date()).toString() + "-修改微信自定义菜单失败！")
            false
        }
    }

    /**
     * 用户关注事件
     * @param eventMap
     */
    def userSubscribe(Map<String, String> eventMap) {
        WeChatUser weChatUser = new WeChatUser()
        weChatUser.setOpenId(eventMap.get("FromUserName"))
        weChatUser.save()
    }

    /**
     * 用户取消关注事件
     * @param eventMap
     * @return
     */
    def userUnsubscribe(Map<String, String> eventMap) {
        WeChatUser weChatUser = WeChatUser.findByOpenId(eventMap.get("FromUserName"))
        if (weChatUser) {
            weChatUser.delete()
        }
    }
}
