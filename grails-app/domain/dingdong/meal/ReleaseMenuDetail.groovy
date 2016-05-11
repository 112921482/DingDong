package dingdong.meal

class ReleaseMenuDetail {

    MealMenu mealMenu
    Integer amount
    BigDecimal price

    static belongsTo = [releaseMenu: ReleaseMenu]

    static mapping = {
        mealMenu comment: "meal_menu主键，订菜详情"
        amount comment: "备货数量"
        price comment: "出售价格"
    }

    static constraints = {
    }
}
