package weixin

import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatMarketController {

    def index() {
        render "OK"
    }
}
