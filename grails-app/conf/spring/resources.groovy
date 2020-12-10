import proytoo115.UserPasswordEncoderListener
import proytoo115.FailedLoginListener

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    failedLoginListener(FailedLoginListener)
}
