package dingdong

import dingdong.meal.MealMenu
import dingdong.meal.MealPic
import grails.transaction.Transactional

@Transactional
class MaintenanceService {

    def saveMenu(String menuName, BigDecimal menuPrice, String[] savePathList) {
        MealMenu mealMenu = new MealMenu(
                name: menuName,
                price: menuPrice
        )
        mealMenu.save()
        savePathList.each { savePath ->
            MealPic mealPic = new MealPic(
                    picUrl: savePath,
                    mealMenu: mealMenu
            )
            mealPic.save()
        }
    }
}
