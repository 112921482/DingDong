package dingdong.MealMenu

import dingdong.meal.MealMenu
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class MaintenanceController {

    def uploadService
    def maintenanceService

    /**
     * 菜单列表页
     * @return
     */
    def index() {
        List<MealMenu> mealMenuList = MealMenu.findAll()
        [mealMenuList: mealMenuList]
    }

    /**
     * 上传图片
     * @return
     */
    def uploadMenuPic() {
        def picFiles = request.getFiles("file[]")
        def rs = uploadService.uploadPic(picFiles)
        render rs as JSON
    }

    /**
     * 保存菜单
     * @return
     */
    def saveMenu() {
        def savePathList = params.savePathString.toString().split(",")
        maintenanceService.saveMenu(params.menuName, new BigDecimal(params.menuPrice.toString()).setScale(2, BigDecimal.ROUND_HALF_UP), savePathList)
        redirect action: "index"
    }

    def deleteMenu(Long id) {
        def rs = [
                result: maintenanceService.deleteMenu(10)
        ]
        render rs as JSON
    }
}
