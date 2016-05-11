package dingdong

import grails.transaction.Transactional

@Transactional
class DateService {

    /**
     * 获得上个月开始时间
     * @param startTime
     * @return
     */
    static Date formatLastMonthStartTime(Date startTime) {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(startTime)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MONTH, -1)
        return calendar.getTime()
    }

    /**
     * 获得上个月结束时间
     * @param endTime
     * @return
     */
    static Date formatLastMonthEndTime(Date endTime) {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(endTime)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.SECOND, -1)
        return calendar.getTime()
    }

    /**
     * 获得今天开始时间
     * @param startTime
     * @return
     */
    static Date formatTodayStartTime(Date startTime) {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(startTime)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        return calendar.getTime()
    }

    /**
     * 获得今天结束时间
     * @param endTime
     * @return
     */
    static Date formatTodayEndTime(Date endTime) {
        Calendar calendar = Calendar.getInstance()
        calendar.setTime(endTime)
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        return calendar.getTime()
    }
}
