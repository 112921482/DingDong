package dingdong

import com.budjb.httprequests.HttpRequest
import com.budjb.httprequests.jersey1.JerseyHttpClientFactory
import dingdong.customer.WeChatUser
import grails.plugin.cache.CachePut
import grails.plugin.cache.Cacheable
import grails.transaction.Transactional
import org.grails.web.util.WebUtils

import static grails.async.Promises.task

@Transactional
class WeChatService {

    def grailsApplication

    /**
     * 获取用户信息
     * @param code
     * @return
     */
    def getUserInfo(String code) {
        def promise = task {
            Map dataMap = new HashMap()
            //循环3次
            1..3.each {
                log.info((new Date()).toString() + "-根据授权code从微信请求token以获取用户信息")
                def client = new JerseyHttpClientFactory().createHttpClient()
                def request = new HttpRequest()
                        .setUri("https://api.weixin.qq.com/sns/oauth2/access_token?appid=${grailsApplication.config.weixin?.appId}&secret=${grailsApplication.config.weixin?.appSecret}&code=${code}&grant_type=authorization_code")
                        .setAccept("application/json")
                def response = client.get(request)
                dataMap = response.getEntity(Map)
                if (!dataMap.get("errcode")) {
                    return false
                }
            }
            dataMap
        }
        def result = promise.get()
        def webUtils = WebUtils.retrieveGrailsWebRequest()
        def session = webUtils.getSession()
        session.openid = result.get("openid")
    }

    /**
     * 获取微信access_token
     * @return
     */
    @Cacheable(value = "WeChatToken")
    Map getWeChatToken() {
        def promise = task {
            log.info((new Date()).toString() + "-从微信请求token")
            Map dataMap = new HashMap()
            1..3.each {
                def client = new JerseyHttpClientFactory().createHttpClient()
                def request = new HttpRequest()
                        .setUri("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${grailsApplication.config.weixin?.appId}&secret=${grailsApplication.config.weixin?.appSecret}")
                        .setAccept("application/json")
                def response = client.get(request)
                dataMap = response.getEntity(Map)
                if (!dataMap.get("errcode")) {
                    return false
                }
            }
            return dataMap
        }
        Map result = (Map) promise.get()
        return result
    }

    /**
     * 更新微信access_token
     * @return
     */
    @CachePut(value = "WeChatToken")
    Map updateWeChatToken() {
        def promise = task {
            log.info((new Date()).toString() + "-从微信更新token")
            Map dataMap = new HashMap()
            1..3.each {
                def client = new JerseyHttpClientFactory().createHttpClient()
                def request = new HttpRequest()
                        .setUri("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${grailsApplication.config.weixin?.appId}&secret=${grailsApplication.config.weixin?.appSecret}")
                        .setAccept('application/json')
                def response = client.get(request)
                dataMap = response.getEntity(Map)
                if (!dataMap.get("errcode")) {
                    return false
                }
            }
            return dataMap
        }
        Map result = (Map) promise.get()
        return result
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
        String openId = eventMap.get("FromUserName")
        WeChatUser weChatUser = WeChatUser.findByOpenId(openId)
        if (!weChatUser) {
            weChatUser = new WeChatUser()
            weChatUser.setOpenId(eventMap.get("FromUserName"))
        }
        weChatUser.setSubscribe((short) 1)
        weChatUser.save()
    }

    /**
     * 用户取消关注事件
     * @param eventMap
     * @return
     */
    def userUnsubscribe(Map<String, String> eventMap) {
        WeChatUser weChatUser = WeChatUser.findByOpenId(eventMap.get("FromUserName"))
        if (!weChatUser) {
            weChatUser = new WeChatUser()
            weChatUser.setOpenId(eventMap.get("FromUserName"))
        }
        weChatUser.setSubscribe((short) 0)
        weChatUser.save()
    }
}
