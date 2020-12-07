package proytoo115

import grails.converters.JSON
import grails.plugin.springsecurity.ui.CommandObject
import grails.plugin.springsecurity.ui.RegisterCommand

//import grails.plugin.springsecurity.ui.RegisterCommand
import grails.plugin.springsecurity.ui.RegistrationCode

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {

    def register(RegisterCommand registerCommand) {


        String mail = registerCommand.email

        if (!request.post) {
            return [registerCommand: new RegisterCommand()]
        }

        if (registerCommand.hasErrors()) {
            return [registerCommand: registerCommand]
        }

        def user = uiRegistrationCodeStrategy.createUser(registerCommand)

        RegistrationCode registrationCode = uiRegistrationCodeStrategy.register(user, registerCommand.password)

        if (registrationCode == null || registrationCode.hasErrors()) {
            // null means problem creating the user
            flash.error = message(code: 'spring.security.ui.register.miscError')
            return [registerCommand: registerCommand]
        }


        redirect(action: "SoyYo",params: [user: registerCommand.username,registrationCode: registrationCode.id,email:mail])

    

    }
   def SoyYo()
    {
      // def registerCommand = params.registerCommand
      // def user = params.user
      //  def registrationCode = params.registrationCode




       // respond registerCommand,user

    }
      def PorCorreo()
    {   String email = params.email
        String user = params.user
        User user2 = User.findByUsername(user)
       // String registerCommand = params.registerCommand
        RegisterCommand registerCommand1 = new RegisterCommand()
        registerCommand1.username = user2.username
        registerCommand1.email = email
        registerCommand1.password = user2.password
        registerCommand1.password2 = user2.password

        String registrationCode = params.registrationCode
        RegistrationCode registrationCode1 = RegistrationCode.findById(registrationCode)





            if( requireEmailValidation  ) {
                sendVerifyRegistrationMail registrationCode1, user2, email
                [emailSent: true, registerCommand: registerCommand1]
                redirect(action: "SoyYo",params: [ emailSent: true])

            } else {
                redirectVerifyRegistration(uiRegistrationCodeStrategy.verifyRegistration(registrationCode1.token))
            }

    }


}
