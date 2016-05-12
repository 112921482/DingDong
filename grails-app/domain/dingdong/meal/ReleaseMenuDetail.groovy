package dingdong.meal

class ReleaseMenuDetail {

    MealMenu mealMenu
    Integer amount
    BigDecimal price
    Boolean enable

    static belongsTo = [releaseMenu: ReleaseMenu]

    static mapping = {
        mealMenu comment: "meal_menu主键，订菜详情"
        amount comment: "备货数量"
        price comment: "出售价格"
        enable comment: "上线状态（true-上线，false-下架）"
    }

    static constraints = {
    }
}
