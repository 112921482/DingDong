package dingdong

import dingdong.meal.ReleaseMenuDetail
import grails.transaction.Transactional

@Transactional
class ReleaseService {

    def logService

    /**
     * 更新上架/下架状态
     * @param id realMenuDetail主键
     * @param enable true-上架，false-下架
     */
    def updateSellStatus(Long id, Boolean enable) {
        Boolean rs = true
        ReleaseMenuDetail releaseMenuDetail = ReleaseMenuDetail.get(id)
        if (releaseMenuDetail) {
            releaseMenuDetail.setEnable(enable)
            if (releaseMenuDetail.validate()) {
                releaseMenuDetail.save()
            } else {
                logService.logErrorMsg(releaseMenuDetail.errors.allErrors)
                rs = false
            }
        } else {
            rs = false
        }
        return rs
    }
}
