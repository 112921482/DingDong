package dingdong.customer

class WeChatUser {

    String openId
    String weChatUserName
    Date createDate

    static mapping = {
        id generator: "assigned", name: "openId"
        weChatUserName comment: "昵称"
    }

    static hasMany = [deliveryAddresses: DeliveryAddress]

    static constraints = {
        weChatUserName nullable: true
    }

    def beforeInsert() {
        createDate = new Date()
    }
}
