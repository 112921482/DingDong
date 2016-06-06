package weixin

import dingdong.meal.ReleaseMenuDetail
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatMarketController {

    def dateService

    static defaultAction = "menuList"

    /**
     * 订餐列表页
     * @return
     */
    def menuList() {
        List<ReleaseMenuDetail> releaseMenuDetailList = ReleaseMenuDetail.createCriteria().list() {
            releaseMenu {
                between("releaseDate", dateService.formatTodayStartTime(new Date()), dateService.formatTodayEndTime(new Date()))
            }
            eq("enable", true)
            order("id", "desc")
        }
        println(session.openid)
        [releaseMenuDetailList: releaseMenuDetailList]
    }
}
