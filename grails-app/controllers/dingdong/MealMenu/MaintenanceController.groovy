package dingdong.MealMenu

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class MaintenanceController {

    def uploadService

    def index() {}

    def saveMenu() {
        def rs = true
        def picFile = request.getFile("file")
        rs = uploadService.uploadPic(picFile)
        return rs
    }
}
