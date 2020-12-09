package proytoo115

class BootStrap {

    def init = { servletContext ->


        def adminRole
        Role.withTransaction { rl ->
            adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        }


        def testUser
        User.withTransaction { us ->
            testUser = new User(username: 'jacksparrow', password: 'password1', fullname: 'Jack Sparrow', email: 'fermerinonew@gmail.com',phoneNumber: '72727281',countryCode: '+503',authyUserId: 320119439).save(flush: true)
        }

        UserRole.create testUser, adminRole

        UserRole.withTransaction { urole ->
            UserRole.withSession {
                it.flush()
                it.clear()
            }
        }
    }
}