package dingdong

class WeChatMarketInterceptor {

    boolean before() {
        if (!request.getParameter("code")) {
            //没有code则不跳转，进行微信授权验证
            def requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE#wechat_redirect"
            def redirectUrl = request.getRequestURL().toString()
            requestUrl = requestUrl.replace("APPID", grailsApplication.config.weixin.appId)
            requestUrl = requestUrl.replace("REDIRECT_URI", redirectUrl)
            requestUrl = requestUrl.replace("SCOPE", "snsapi_userinfo")
            redirect(url: requestUrl)
            false
        } else {
            //有code则保存用户信息
            true
        }
    }

    boolean after() { true }
}
