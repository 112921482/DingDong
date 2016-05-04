package dingdong.MealMenu

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class MaintenanceController {

    def uploadService
    def maintenanceService

    def index() {}

    def saveMenu() {

        def picFiles = request.getFiles("file[]")
        def rs = uploadService.uploadPic(picFiles)
        if (rs.result) {
            maintenanceService.saveMenu(params.menuName, new BigDecimal(params.menuPrice.toString()).setScale(2, BigDecimal.ROUND_HALF_UP), rs.savePathList)
        }
        redirect action: "index"
    }
}
