import dingdong.security.Role
import dingdong.security.User
import dingdong.security.UserRole

class BootStrap {

    def init = {
        def adminRole = new Role(authority: 'ROLE_ADMIN')
        adminRole.save()
        def userRole = new Role(authority: 'ROLE_USER')
        userRole.save()
        def testUser = new User(username: '112921482', password: 'a19521439')
        testUser.save()
        UserRole.create testUser, adminRole
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1
    }
    def destroy = {
    }
}
