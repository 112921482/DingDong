package dingdong.customer

class WeChatUser {

    String name //昵称

    static hasMany = [deliveryAddresses: DeliveryAddress]

    static constraints = {
    }
}
