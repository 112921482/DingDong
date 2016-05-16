package weixin

import grails.plugin.springsecurity.annotation.Secured

class WeChatController {

    def weChatService

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
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

    @Secured("ROLE_ADMIN")
    def diyMenu() {
        Boolean rs = weChatService.diyMenu()
        if (rs) {
            render "菜单修改成功！"
        } else {
            render "菜单修改失败！"
        }
    }
}
