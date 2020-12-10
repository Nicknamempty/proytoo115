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
            render view: 'resetPassword', model: [username: session['SPRING_SECURITY_LAST_USERNAME']]
            return
        }

        User user = User.findByUsername(username2)

        user.password = password_new
        user.passwordExpired = false
        user.enabled = true
        user.accountLocked = true
        user.accountExpired = false
        user.save() // if you have password constraints check them here

        redirect controller: 'login', action: 'auth'
    }

    def resetPassword() {
        return
    }
}
