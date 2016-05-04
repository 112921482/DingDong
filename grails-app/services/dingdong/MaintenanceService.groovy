package dingdong

import dingdong.meal.MealMenu
import dingdong.meal.MealPic
import grails.transaction.Transactional

@Transactional
class MaintenanceService {

    def saveMenu(String menuName, BigDecimal menuPrice, String[] savePathList) {
        Boolean rs = true
        try {
            MealMenu mealMenu = new MealMenu(
                    name: menuName,
                    price: menuPrice
            )
            mealMenu.save(flush: true)
            savePathList.each { savePath ->
                MealPic mealPic = new MealPic(
                        picUrl: savePath,
                        mealMenu: mealMenu
                )
                mealPic.save(flush: true)
            }
        } catch (Exception ex) {
            log.error(ex.getMessage())
            rs = false
        }
        return rs
    }

    def deleteMenu(Long id) {
        Boolean rs = true
        MealMenu mealMenu = MealMenu.get(id)
        try {
            mealMenu.delete(flush: true)
        } catch (Exception ex) {
            log.error(ex.getMessage())
            rs = false
        }
        return rs
    }
}
