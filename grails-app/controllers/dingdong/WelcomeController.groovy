package dingdong

import grails.plugin.springsecurity.annotation.Secured
import orderManagement.TakeOutOrder

class WelcomeController {

    def dateService

    @Secured('ROLE_ADMIN')
    def index() {
        def takeOutOrderList = TakeOutOrder.findAllByCreateTimeBetween(dateService.formatLastMonthStartTime(new Date()), dateService.formatLastMonthEndTime(new Date()))
        [takeOutOrderList: takeOutOrderList]
    }
}
