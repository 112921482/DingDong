package dingdong.orderManagement

class TakeOutOrderDetail {

    Integer amount
    Integer status
    Date createTime
    Date updateTime

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
