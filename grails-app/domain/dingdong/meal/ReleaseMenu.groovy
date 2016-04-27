package dingdong.meal

class ReleaseMenu {

    MealMenu mealMenu
    Integer amount //数量
    Date releaseDate //发布时间

    static constraints = {
    }

    def beforeInsert() {
        releaseDate = new Date()
    }
}
