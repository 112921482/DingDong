package dingdong.meal

class ReleaseMenu {

    Short type
    Date releaseDate

    static hasMany = [releaseMenuDetails: ReleaseMenuDetail]

    static mapping = {
        type comment: "菜单种类（无限制-0，早餐-1，中餐-2，晚餐-3，宵夜-4）"
        releaseMenuDetails sort: 'id', order: 'desc'
        releaseDate comment: "发布时间"
    }

    static constraints = {
        releaseDate nullable: true
    }

    def beforeInsert() {
        releaseDate = new Date()
    }
}
