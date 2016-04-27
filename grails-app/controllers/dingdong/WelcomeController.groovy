package dingdong

import grails.plugin.springsecurity.annotation.Secured

class WelcomeController {

    @Secured('ROLE_ADMIN')
    def index() {
        [xixi: "xixi"]
    }
}
