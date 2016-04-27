package dingdong.orderManagement

class TakeOutOrder {

    String name
    String address
    String mobile
    Date createTime
    Date updateTime

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
