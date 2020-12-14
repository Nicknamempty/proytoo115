package proytoo115


class NuevoUsuarioInterceptor {
    def springSecurityService
    NuevoUsuarioInterceptor()
    {
        matchAll().excludes(controller:'register',action:'forgotPassword').excludes(uri:'register/securityQuestions').excludes(controller:'register')
    }



    boolean before() {
       if (springSecurityService.isLoggedIn()  && session.verified) {
            User user = User.findByUsername(springSecurityService.principal.username)
            Perfil perfil = Perfil.findByUser(user)

            if(user.newUser && perfil != null){redirect controller:'register',  action: 'forgotPassword'
            return false}
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
