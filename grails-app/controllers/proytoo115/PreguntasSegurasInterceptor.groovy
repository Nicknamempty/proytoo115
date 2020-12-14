package proytoo115


class PreguntasSegurasInterceptor {
    def springSecurityService

    PreguntasSegurasInterceptor() {
        matchAll().excludes(controller:'perfil', action:'create')
    }

    boolean before() {

        if (!(params.controller in ["register", "stomp"]) && springSecurityService.isLoggedIn()  && session.verified)
        {  User user = User.findByUsername(springSecurityService.principal.username)
            Perfil perfil = Perfil.findByUser(user)
            if(perfil==null){ redirect controller:'perfil',  action: 'create'
            return true}
        }


        true }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
