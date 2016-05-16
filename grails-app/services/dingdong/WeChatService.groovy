package dingdong

import com.budjb.httprequests.HttpRequest
import com.budjb.httprequests.jersey1.JerseyHttpClientFactory
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
    @Cacheable(value = "WeChatToken", key = "1000")
    Map getWeChatToken() {
        log.info((new Date()).toString() + "-从微信请求token")
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
}
