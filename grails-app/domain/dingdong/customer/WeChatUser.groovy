package dingdong.customer

class WeChatUser {

    String name

    static hasMany = [deliveryAddresses: DeliveryAddress]

    static constraints = {
    }
}
