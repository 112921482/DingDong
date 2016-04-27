package dingdong

import grails.plugin.springsecurity.annotation.Secured
import dingdong.orderManagement.TakeOutOrder

@Secured('ROLE_ADMIN')
class WelcomeController {

    def dateService
    def index() {
        def takeOutOrderList = TakeOutOrder.findAllByCreateTimeBetween(dateService.formatLastMonthStartTime(new Date()), dateService.formatLastMonthEndTime(new Date()))
        [takeOutOrderList: takeOutOrderList]
    }
}
