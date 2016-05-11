package dingdong.orderManagement

import dingdong.meal.ReleaseMenuDetail

class TakeOutOrderDetail {

    ReleaseMenuDetail releaseMenuDetail
    Integer amount
    Integer status
    Date createTime
    Date updateTime

    static belongsTo = [takeOutOrder: TakeOutOrder]

    static mapping = {
        releaseMenu comment: "release_menu表主键关联，订的什么菜"
        amount comment: "数量"
        status comment: "烹饪状态(0-未烹饪，1-已烹饪)"
        createTime comment: "创建时间"
        updateTime comment: "更新时间"
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
