package weixin

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatController {

    def weChatService

    def index() {
        def cache = weChatService.getWeChatToken()
        render cache as JSON
    }
}
