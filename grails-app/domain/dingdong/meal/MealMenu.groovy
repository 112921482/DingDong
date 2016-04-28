package dingdong.meal

class MealMenu {

    String name
    BigDecimal price
    String picUrl
    Date createTime
    Date updateTime

    static mapping = {
        name comment: "菜名"
        price comment: "价格"
        picUrl comment: "图片地址"
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
