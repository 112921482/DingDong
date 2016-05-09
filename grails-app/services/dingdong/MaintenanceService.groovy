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
        if (!mealMenu.validate()) {
            mealMenu.errors.allErrors.each {
                def msg = it.getDefaultMessage()
                it.getArguments().eachWithIndex { arg, index ->
                    msg = msg.replace("[{${index}}]", arg.toString())
                }
                log.error(msg)
            }
            rs = false
        } else {
            mealMenu.save()
            savePathList.each { savePath ->
                MealPic mealPic = new MealPic(
                        picUrl: savePath,
                        mealMenu: mealMenu
                )
                if (!mealPic.validate()) {
                    mealPic.errors.allErrors.each {
                        def msg = it.getDefaultMessage()
                        it.getArguments().eachWithIndex { arg, index ->
                            msg = msg.replace("[{${index}}]", arg.toString())
                        }
                        log.error(msg)
                    }
                    rs = false
                    return false
                } else {
                    mealPic.save()
                }
            }
        }
        return rs
    }

    /**
     * 删除菜单
     * @param id 菜单ID
     * @return
     */
    def deleteMenu(Long id) {
        Boolean rs = true
        MealMenu mealMenu = MealMenu.get(id)
        if (!mealMenu) {
            rs = false
        } else {
            mealMenu.delete()
        }
        return rs
    }
}
