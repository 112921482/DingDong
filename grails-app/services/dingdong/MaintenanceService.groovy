package dingdong

import dingdong.meal.MealMenu
import dingdong.meal.MealPic
import grails.transaction.Transactional

@Transactional
class MaintenanceService {

    /**
     * 保存菜单
     * @param menuName 菜名
     * @param menuPrice 价格
     * @param savePathList 图片列表
     * @return
     */
    def saveMenu(String menuName, BigDecimal menuPrice, String[] savePathList) {
        Boolean rs = true
        MealMenu mealMenu = new MealMenu(
                name: menuName,
                price: menuPrice
        )
        if (!mealMenu.save()) {
            rs = false
        } else {
            savePathList.each { savePath ->
                MealPic mealPic = new MealPic(
                        picUrl: savePath,
                        mealMenu: mealMenu
                )
                mealPic.save()
                if (!mealPic.save()) {
                    rs = false
                    return false
                }
            }
        }
    }

    /**
     * 删除菜单
     * @param id 菜单ID
     * @return
     */
    def deleteMenu(Long id) {
        Boolean rs = true
        MealMenu mealMenu = MealMenu.get(id)
        if (mealMenu) {
            if (!mealMenu.delete()) {
                rs = false
            }
        } else {
            rs = false
        }
        return rs
    }
}
