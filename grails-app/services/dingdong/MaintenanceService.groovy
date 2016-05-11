package dingdong

import dingdong.meal.MealMenu
import dingdong.meal.MealPic
import dingdong.meal.ReleaseMenu
import dingdong.meal.ReleaseMenuDetail
import grails.transaction.Transactional

import java.math.RoundingMode

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

    /**
     * 更新菜单数据
     * @param menuName
     * @param menuPrice
     * @param savePathList
     * @return
     */
    def updateMenu(Long menuId, String menuName, BigDecimal menuPrice, String[] savePathList) {
        Boolean rs = true
        MealMenu mealMenu = MealMenu.get(menuId)
        if (!mealMenu) {
            log.error("ID为${menuId}的菜不存在！")
            rs = false
        } else {
            mealMenu.setName(menuName)
            mealMenu.setPrice(menuPrice)
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
                if (savePathList.size() > 0) {
                    mealMenu.getMealPics().each { oldPic ->
                        def tempMealMenu = oldPic.getMealMenu()
                        tempMealMenu.removeFromMealPics(oldPic);
                        oldPic.delete()
                    }
                    //先删除以前的图
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
            }
        }
        return rs
    }

    def releaseMenu(Map params) {
        Boolean rs = true
        ReleaseMenu releaseMenu = new ReleaseMenu(
                type: 0
        )
        if (!releaseMenu.validate()) {
            releaseMenu.errors.allErrors.each {
                def msg = it.getDefaultMessage()
                it.getArguments().eachWithIndex { arg, index ->
                    msg = msg.replace("[{${index}}]", arg.toString())
                }
                log.error(msg)
            }
            rs = false
        } else {
            releaseMenu.save()
            params.selectedMenuId.each { menuId ->
                MealMenu tempMealMenu = MealMenu.get(menuId)
                if (tempMealMenu) {
                    ReleaseMenuDetail releaseMenuDetail = new ReleaseMenuDetail(
                            mealMenu: tempMealMenu,
                            amount: params.int("selectedMenu.${menuId}.sellAmount"),
                            releaseMenu: releaseMenu,
                            price: new BigDecimal(params["selectedMenu.${menuId}.sellPrice"].toString()).setScale(2, RoundingMode.HALF_UP)
                    )
                    if (!releaseMenuDetail.validate()) {
                        releaseMenuDetail.errors.allErrors.each {
                            def msg = it.getDefaultMessage()
                            it.getArguments().eachWithIndex { arg, index ->
                                msg = msg.replace("[{${index}}]", arg.toString())
                            }
                            log.error(msg)
                        }
                        rs = false
                    } else {
                        releaseMenuDetail.save()
                    }
                } else {
                    log.error("ID为${menuId}的菜不存在！")
                    rs = false
                }
            }
        }
        return rs
    }
}
