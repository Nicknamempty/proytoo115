package proytoo115

class BootStrap {
    def springSecurityService
    def init = { servletContext ->

        for (String url in [
                '/', '/error', '/index', '/index.gsp', '/**/favicon.ico', '/shutdown',
                '/assets/**', '/**/js/**', '/**/css/**', '/**/images/**',
                '/login', '/login.*', '/login/*',
                '/logout', '/logout.*', '/logout/*','/register/**']) {
            new Requestmap(url: url, configAttribute: 'permitAll').save()
        }

        new Requestmap(url: '/profile/**',    configAttribute: 'ROLE_ADMIN').save()
        new Requestmap(url: '/requestmap/**',    configAttribute: 'ROLE_ADMIN').save()
        new Requestmap(url: '/admin/**',      configAttribute: 'ROLE_ADMIN').save()
        new Requestmap(url: '/admin/role/**', configAttribute: 'ROLE_ADMIN').save()
        new Requestmap(url: '/admin/user/**',
                configAttribute: 'ROLE_ADMIN,ROLE_SUPERVISOR').save()

        springSecurityService.clearCachedRequestmaps()
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