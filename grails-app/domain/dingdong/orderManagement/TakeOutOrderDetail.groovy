package dingdong.orderManagement

import dingdong.meal.ReleaseMenu

class TakeOutOrderDetail {

    ReleaseMenu releaseMenu //订的菜
    Integer amount //数量
    Integer status //(0-未烹饪，1-已烹饪)
    Date createTime //创建时间
    Date updateTime //更新时间

    static belongsTo = [takeOutOrder: TakeOutOrder]

    static constraints = {
    }

    def beforeInsert() {
        createTime = new Date()
    }

    def beforeUpdate() {
        updateTime = new Date()
    }
}
