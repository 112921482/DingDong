package dingdong

class WeChatJob {

    def weChatService

    static triggers = {
        simple repeatInterval: 3600000l
    }

    def execute() {
        weChatService.updateWeChatToken()
    }
}
