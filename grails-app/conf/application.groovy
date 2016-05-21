// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'dingdong.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'dingdong.security.UserRole'
grails.plugin.springsecurity.authority.className = 'dingdong.security.Role'
//登出可以使用get方式
grails.plugin.springsecurity.logout.postOnly = false
//设置默认登陆成功页面
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/welcome'
//登陆成功总是跳转到登录成功页
grails.plugin.springsecurity.successHandler.alwaysUseDefault = true

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]