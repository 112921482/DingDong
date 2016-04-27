package dingdong.meal

class MealMenu {

    String name //菜名
    BigDecimal price //价格
    String picUrl //图片地址
    Date createTime //创建时间
    Date updateTime //修改时间

    static constraints = {
    }

    def beforeInsert() {
        createTime = new Date()
    }

    def beforeUpdate() {
        updateTime = new Date()
    }
}
