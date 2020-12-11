package proytoo115

class UserController extends grails.plugin.springsecurity.ui.UserController {
    def updatePassword(String username, String password, String password_new, String password_new_2) {
        println(username)
        println(password_new)
        String username2 = username
        if (!username2) {
            flash.message = 'Sorry, an error has occurred'
            redirect controller: 'login', action: 'auth'
            return
        }

        if (!password || !password_new || !password_new_2 || password_new != password_new_2) {
            flash.message = 'Please enter your current password and a valid new password'
            render view: 'resetPassword', username2
            return
        }

        User user = User.findByUsername(username2)

        user.password = password_new
        user.passwordExpired = false
        user.enabled = true
        user.accountLocked = false
        user.accountExpired = false
        user.save() // if you have password constraints check them here

        Historial_Contrasena historial_contrasena = new Historial_Contrasena()
        historial_contrasena.usuario = username2
        historial_contrasena.contrasena = password_new
        historial_contrasena.save()

        redirect controller: 'login', action: 'auth'
    }

    def resetPassword() {
        return
    }
}
