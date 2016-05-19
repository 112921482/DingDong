package weixin

import dingdong.meal.ReleaseMenuDetail
import grails.plugin.springsecurity.annotation.Secured

@Secured("IS_AUTHENTICATED_ANONYMOUSLY")
class WeChatMarketController {

    def dateService

    /**
     * 订餐列表页
     * @return
     */
    def index() {
        List<ReleaseMenuDetail> releaseMenuDetailList = ReleaseMenuDetail.createCriteria().list() {
            releaseMenu {
                between("releaseDate", dateService.formatTodayStartTime(new Date()), dateService.formatTodayEndTime(new Date()))
            }
            eq("enable", true)
            order("id", "desc")
        }
        [releaseMenuDetailList: releaseMenuDetailList]
    }
}
