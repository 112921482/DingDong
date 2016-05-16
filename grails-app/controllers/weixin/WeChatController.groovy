package weixin

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatController {

    def weChatService

    def index() {
        def cache = weChatService.getWeChatToken()
        if ((new Date()).getTime() - cache.get("getTime").toString() > 7000000) {
            cache = weChatService.updateWeChatToken()
        }
        render cache as JSON
    }
}
