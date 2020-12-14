package proytoo115


class ParaAuthyInterceptor {


    def springSecurityService

    ParaAuthyInterceptor() {
        matchAll()
    }



    boolean before() {
        if (!(params.controller in ["register", "stomp"]) && springSecurityService.isLoggedIn() && !session.verified) {
            redirect controller: 'register', action: 'verify'
            return false
        }

        true
    }
    boolean after() { true }

    void afterView() {
        // no-op
    }
}
