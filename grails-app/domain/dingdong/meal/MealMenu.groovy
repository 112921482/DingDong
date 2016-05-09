package dingdong.meal

class MealMenu {

    String name
    BigDecimal price
    Date createTime
    Date updateTime

    static hasMany = [mealPics: MealPic]

    static mapping = {
        name comment: "菜名"
        price comment: "价格"
        createTime comment: "创建时间"
        updateTime comment: "更新时间"
    }

    static constraints = {
        price max: 1000000.00, min: 0.00, scale: 2
        createTime nullable: true
        updateTime nullable: true
    }

    def beforeInsert() {
        createTime = new Date()
    }

    def beforeUpdate() {
        updateTime = new Date()
    }
}
