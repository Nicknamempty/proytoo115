package proytoo115

class BootStrap {
    def springSecurityService
    def init = { servletContext ->

        for (String url in [
                '/', '/error', '/index', '/index.gsp', '/**/favicon.ico', '/shutdown',
                '/assets/**', '/**/js/**', '/**/css/**', '/**/images/**',
                '/login', '/login.*', '/login/*',
                '/logout', '/logout.*', '/logout/*','/register/**','/perfil/**','/**/**']) {
            new Requestmap(url: url, configAttribute: 'permitAll').save()
        }
        Departamento dep = new Departamento(nombre: 'San Salvador').save()
        new Departamento(nombre: 'Chalatenango').save()
        Municipio municipio = new Municipio(nombre: 'San Salvador',departamento: dep ).save()
        new Municipio(nombre: 'Sanx Salvador',departamento: dep ).save()
        new Municipio(nombre: 'Sanz Salvador',departamento: dep ).save()
        Direccion direccion = new Direccion(municipio: municipio,calle:'asdasd',avenida: 'wqeqw',colonia: 'weqe',numeroCasa: 2).save()
        new Empleado(nombre: 'Oscar',apellido: 'Arteaga',dui: '2313422342',nit: '34234242234243423',email:'fermerinonew@gmail.com',isss: '2323423',genero: 'Masculino',phoneNumber: '72727281',countryCode: '+503',estadoCivil: 'casado',nup:'132242',direccion: direccion).save()
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
            testUser = new User(username: 'Admin', password: 'password1', email: 'fermerinonew@gmail.com',authyUserId: 320119439,newUser: true).save(flush: true)
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