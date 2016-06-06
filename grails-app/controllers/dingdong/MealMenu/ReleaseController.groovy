package dingdong.MealMenu

import dingdong.meal.ReleaseMenu
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class ReleaseController {

    def dateService
    def releaseService

    static defaultAction = "menuList"

    /**
     * 首页
     * @return
     */
    def menuList() {
        List<ReleaseMenu> releaseMenuList = ReleaseMenu.createCriteria().list() {
            if (params.type) {
                eq("type", params.short("type"))
            }
            between("releaseDate", dateService.formatTodayStartTime(new Date()), dateService.formatTodayEndTime(new Date()))
            order("releaseDate", "desc")
        }
        [releaseMenuList: releaseMenuList]
    }

    /**
     * 更新上架/下架状态
     * @param id realMenuDetail主键
     * @param enable true-上架，false-下架
     */
    def updateSellStatus(Long id, Boolean enable) {
        def rs = [result: releaseService.updateSellStatus(id, enable)]
        render rs as JSON
    }
}
