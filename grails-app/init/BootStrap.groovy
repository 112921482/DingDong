import dingdong.Role
import dingdong.User
import dingdong.UserRole

class BootStrap {

    def init = {
        Role adminRole = new Role('ROLE_ADMIN').save()
        Role userRole = new Role('ROLE_USER').save()
        User testUser = new User('112921482', 'a19521439').save()
        UserRole.create(testUser, adminRole)
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
