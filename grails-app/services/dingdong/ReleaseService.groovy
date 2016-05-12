package dingdong

import dingdong.meal.ReleaseMenuDetail
import grails.transaction.Transactional

@Transactional
class ReleaseService {

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
            if (!releaseMenuDetail.save()) {
                releaseMenuDetail.errors.allErrors.each { releaseMenuDetailErr ->
                    log.error(releaseMenuDetailErr)
                }
                rs = false
            }
        } else {
            rs = false
        }
        return rs
    }
}
