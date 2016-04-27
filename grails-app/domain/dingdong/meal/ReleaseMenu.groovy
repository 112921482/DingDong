package dingdong.meal

class ReleaseMenu {

    String name
    BigDecimal price
    String picUrl
    Date releaseDate
    Integer status

    static constraints = {
    }

    def beforeInsert() {
        releaseDate = new Date()
    }
}
