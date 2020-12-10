package proytoo115


class LoginInterceptor {

    def springSecurityService

    public LoginInterceptor(){
        match controller:"login", action:"authfail"
        //Intercepta entre en la accion en error en inicio de sesion del controlador login
    }

    boolean before() {
        true
    }

    boolean after() {
        true
    }

    void afterView() {
        // no-op
    }
}
