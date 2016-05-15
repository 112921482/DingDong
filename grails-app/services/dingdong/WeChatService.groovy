package dingdong

import com.budjb.httprequests.HttpRequest
import com.budjb.httprequests.jersey1.JerseyHttpClientFactory
import grails.plugin.cache.Cacheable
import grails.transaction.Transactional

@Transactional
class WeChatService {

    def grailsApplication

    @Cacheable("WeChatToken")
    Map getWeChatToken() {
        println("向微信请求token")
        def client = new JerseyHttpClientFactory().createHttpClient()
        def request = new HttpRequest()
                .setUri("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=${grailsApplication.config.weixin?.appId}&secret=${grailsApplication.config.weixin?.appSecret}")
                .setAccept('application/json')
        def response = client.get(request)
        def dataMap = response.getEntity(Map)
        dataMap.put("getTime", new Date().getTime())
        return dataMap
    }
}
