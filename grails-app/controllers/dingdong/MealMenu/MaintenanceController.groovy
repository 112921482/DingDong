package dingdong.MealMenu

import dingdong.meal.MealMenu
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class MaintenanceController {

    def uploadService
    def maintenanceService

    def index() {
        List<MealMenu> mealMenuList = MealMenu.findAll()
        [mealMenuList: mealMenuList]
    }

    def saveMenu() {
        def picFiles = request.getFiles("file[]")
        def rs = uploadService.uploadPic(picFiles)
        def mealMenu
        if (rs.result) {
            mealMenu = maintenanceService.saveMenu(params.menuName, new BigDecimal(params.menuPrice.toString()).setScale(2, BigDecimal.ROUND_HALF_UP), rs.savePathList)
        }
        return true
    }
}
