package dingdong.orderManagement

import dingdong.customer.DeliveryAddress

class TakeOutOrder {

    DeliveryAddress deliveryAddress
    Integer status
    Date createTime
    Date updateTime

    static hasMany = [takeOutOrderDetails: TakeOutOrderDetail]

    static mapping = {
        deliveryAddress comment: "delivery_address主键关联，配送地址详情"
        status comment: "订单状态（0-待烹饪，1-已烹饪，待配送，2-配送中，3-收货，4-订单取消）"
        createTime comment: "创建时间"
        updateTime comment: "修改时间"
    }

    static constraints = {
    }

    def beforeInsert() {
        createTime = new Date()
    }

    def beforeUpdate() {
        updateTime = new Date()
    }
}
