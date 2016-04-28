package dingdong.customer

class WeChatUser {

    String name

    static mapping = {
        name comment: "昵称"
    }

    static hasMany = [deliveryAddresses: DeliveryAddress]

    static constraints = {
    }
}
