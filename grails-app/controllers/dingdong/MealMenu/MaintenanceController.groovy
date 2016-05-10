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
        def rs = [
                result: maintenanceService.saveMenu(params.menuName, new BigDecimal(params.menuPrice.toString()).setScale(2, BigDecimal.ROUND_HALF_UP), savePathList)
        ]
        render rs as JSON
    }

    /**
     * 删除菜单
     * @param id 菜单主键
     * @return
     */
    def deleteMenu(Long id) {
        def rs = [
                result: maintenanceService.deleteMenu(id)
        ]
        render rs as JSON
    }

    /**
     * 更新菜单
     * @param id 菜单主键
     */
    def updateMenu(Long menuId) {
        String[] savePathList = new String()[]
        if (params.savePathStringToEdit.length() > 0) {
            savePathList = params.savePathStringToEdit.toString().split(",")
        }
        def rs = [
                result: maintenanceService.updateMenu(menuId, params.menuNameToEdit, new BigDecimal(params.menuPriceToEdit.toString()).setScale(2, BigDecimal.ROUND_HALF_UP), savePathList)
        ]
        render rs as JSON
    }
}
