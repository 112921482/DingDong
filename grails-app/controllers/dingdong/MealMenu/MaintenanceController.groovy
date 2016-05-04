package dingdong.MealMenu

import dingdong.meal.MealMenu
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class MaintenanceController {

    def uploadService
    def maintenanceService

    def index() {
        List<MealMenu> mealMenuList = MealMenu.findAll()
        [mealMenuList: mealMenuList]
    }

    def uploadMenuPic() {
        def picFiles = request.getFiles("file[]")
        def rs = uploadService.uploadPic(picFiles)
        render rs as JSON
    }

    def saveMenu() {
        def savePathList = params.savePathString.toString().split(",")
        maintenanceService.saveMenu(params.menuName, new BigDecimal(params.menuPrice.toString()).setScale(2, BigDecimal.ROUND_HALF_UP), savePathList)
        redirect action: "index"
    }
}
