package dingdong.MealMenu

import dingdong.meal.ReleaseMenu
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class ReleaseController {

    def dateService

    def index() {
        List<ReleaseMenu> releaseMenuList = ReleaseMenu.createCriteria().list() {
            if (params.type) {
                eq("type", params.short("type"))
            }
            between("releaseDate", dateService.formatTodayStartTime(new Date()), dateService.formatTodayEndTime(new Date()))
            order("releaseDate", "desc")
        }
        [releaseMenuList: releaseMenuList]
    }
}
