package weixin

import dingdong.customer.WeChatUser
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatMarketController {

    def index() {
        WeChatUser weChatUser = WeChatUser.findByOpenId(session.openId.toString())
        render weChatUser
    }
}
