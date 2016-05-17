package weixin

import dingdong.meal.ReleaseMenu
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatMarketController {

    def dateService

    /**
     * 订餐列表页
     * @return
     */
    def index() {
        List<ReleaseMenu> releaseMenuList = ReleaseMenu.findAllByReleaseDateBetween(dateService.formatTodayStartTime(new Date()), dateService.formatTodayEndTime(new Date()))
        [releaseMenuList: releaseMenuList]
    }
}
