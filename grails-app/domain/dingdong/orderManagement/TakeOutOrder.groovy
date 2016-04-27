package dingdong.orderManagement

import dingdong.customer.DeliveryAddress

class TakeOutOrder {

    DeliveryAddress deliveryAddress //配送地址
    Integer status //订单状态（0-待烹饪，1-已烹饪，待配送，2-配送中，3-收货，4-订单取消）
    Date createTime //创建时间
    Date updateTime //修改时间

    static hasMany = [takeOutOrderDetails: TakeOutOrderDetail]

    static constraints = {
    }

    def beforeInsert() {
        createTime = new Date()
    }

    def beforeUpdate() {
        updateTime = new Date()
    }
}
