package weixin

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatController {

    def weChatService

    def index(String signature, String echostr, String timestamp, String nonce) {
        if (weChatService.validateSignature(signature, timestamp, nonce)) {
            render echostr
        }
//        def cache = weChatService.getWeChatToken()
//        if (((new Date()).getTime() - cache.get("getTime")) > 7000000) {
//            cache = weChatService.updateWeChatToken()
//        }
//        render "${grailsApplication.config.weixin?.token}"
    }


}
