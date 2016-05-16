import grails.util.BuildSettings

// See http://logback.qos.ch/manual/groovy.html for details on configuration
// 控制台日志级别控制
// 日志级别 TRACE < DEBUG < INFO < WARN < ERROR，默认只打印ERROR
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}
root(INFO, ['STDOUT'])

// 日志输出控制
// 日志路径
def targetDir = BuildSettings.TARGET_DIR
// 项目名称
def projectName = "dingdong"
// 日志日期
def byDay = timestamp("yyyyMMdd")

appender("STDOUT", FileAppender) {
    file = "${targetDir}/${projectName}_${byDay}.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}
root(INFO, ['STDOUT'])
