package dingdong.meal

class ReleaseMenu {

    MealMenu mealMenu
    Integer amount
    Date releaseDate

    static mapping = {
        mealMenu comment: "meal_menu主键，订菜详情"
        amount comment: "价格"
        releaseDate comment: "图片地址"
    }

    static constraints = {
    }

    def beforeInsert() {
        releaseDate = new Date()
    }
}
