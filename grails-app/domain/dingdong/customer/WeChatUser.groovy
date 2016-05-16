package dingdong.customer

class WeChatUser {

    String openId
    String weChatUserName
    Date createDate

    static mapping = {
        id generator: "assigned", name: "openId", comment: "用户的标识，对当前公众号唯一"
        weChatUserName comment: "昵称"
    }

    static hasMany = [deliveryAddresses: DeliveryAddress]

    static constraints = {
        weChatUserName nullable: true
        createDate nullable: true
    }

    def beforeInsert() {
        createDate = new Date()
    }
}
