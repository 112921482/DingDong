package dingdong.meal

class MealPic {

    String picUrl

    static belongsTo = [mealMenu: MealMenu]

    static mapping = {
        picUrl comment: "图片地址"
        mealMenu comment: "meal_menu外键关联"
    }

    static constraints = {
    }
}
