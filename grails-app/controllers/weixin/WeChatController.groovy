package weixin

import grails.plugin.springsecurity.annotation.Secured

class WeChatController {

    def weChatService

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def index(String signature, String echostr, String timestamp, String nonce) {
        log.info("微信事件推送")
        if (echostr) {
            if (weChatService.validateSignature(signature, timestamp, nonce)) {
                render echostr
            }
        }
        def xmlParse = new XmlParser()
        def xmlData = xmlParse.parse(request.getInputStream())
        Map<String, String> eventMap = new HashMap<String, String>()
        xmlData.value().each {
            eventMap.put(it.name(), it.text())
        }
        //关注事件
        if (eventMap.get("Event").equals("subscribe")) {
            weChatService.userSubscribe(eventMap)
        }
        //取消关注事件
        if (eventMap.get("Event").equals("unsubscribe")) {
            weChatService.userUnsubscribe(eventMap)
        }
        //点击跳转事件
//        if (eventMap.get("Event").equals("VIEW")) {
//            session.openId = eventMap.get("openid")
//        }
        render ""
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
