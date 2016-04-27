package dingdong

import grails.transaction.Transactional

@Transactional
class DateService {

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
}
