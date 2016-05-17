package dingdong.customer

class WeChatUser {

    String openId
    String accessToken
    String refreshToken
    String unionid
    Long getTime
    Date createDate

    String country
    String headimgurl
    String nickname
    Integer sex

    static transients = ["country", "headimgurl", "nickname", "sex"]

    static mapping = {
        id generator: "assigned", name: "openId", comment: "用户的标识，对当前公众号唯一"
        accessToken comment: "网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同"
        refreshToken comment: "用户刷新access_token"
        unionid comment: "只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段"
        getTime comment: "获得毫秒数"
    }

    static hasMany = [deliveryAddresses: DeliveryAddress]

    static constraints = {
        accessToken nullable: true
        refreshToken nullable: true
        getTime nullable: true
        unionid nullable: true
        createDate nullable: true
    }

    def beforeInsert() {
        createDate = new Date()
    }
}
