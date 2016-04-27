package dingdong.meal

class MealMenu {

    String name
    BigDecimal price
    String picUrl
    Date createTime
    Date updateTime

    static constraints = {
    }

    def beforeInsert() {
        createTime = new Date()
    }

    def beforeUpdate() {
        updateTime = new Date()
    }
}
