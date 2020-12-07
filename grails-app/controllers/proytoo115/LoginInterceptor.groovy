package proytoo115


class LoginInterceptor {

    def springSecurityService

    public LoginInterceptor(){
        match controller:"login", action:"authfail"

    }

    boolean before() {
        true
    }

    boolean after() {
        println("Hola mundo")
        true
    }

    void afterView() {
        // no-op
    }
}
