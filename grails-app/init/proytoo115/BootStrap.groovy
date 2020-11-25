package proytoo115

class BootStrap {

    def init = { servletContext ->


        def adminRole
        Role.withTransaction { rl ->
            adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        }


        def testUser
        User.withTransaction { us ->
            testUser = new User(username: 'jacksparrow', password: 'password1', fullname: 'Jack Sparrow', email: 'fermerinonew@gmail.com').save(flush: true)
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