package dingdong

import grails.transaction.Transactional



@Transactional
class LogService {

    def logErrorMsg(Collection errors) {
        errors.each {
            def msg = it.getDefaultMessage()
            it.getArguments().eachWithIndex { arg, index ->
                msg = msg.replace("[{${index}}]", arg.toString())
            }
            log.error(msg)
        }
    }
}
