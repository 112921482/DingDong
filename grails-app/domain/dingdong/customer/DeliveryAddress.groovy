package dingdong.customer

class DeliveryAddress {

    String name
    String address
    String mobile

    static belongsTo = [weChatUser: WeChatUser]

    static mapping = {
        name comment: "收货人姓名"
        address comment: "收货人地址"
        mobile comment: "收货人联系电话"
    }

    static constraints = {
    }
}
