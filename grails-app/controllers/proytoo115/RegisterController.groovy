package proytoo115

import grails.converters.JSON
import grails.plugin.springsecurity.ui.CommandObject
import grails.plugin.springsecurity.ui.RegisterCommand


import grails.plugin.springsecurity.ui.RegistrationCode

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {
    def springSecurityService
    def registerService

    def register(RegisterCommand registerCommand)
    {
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
    {}
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
            if( requireEmailValidation ) {
                sendVerifyRegistrationMail registrationCode1, user2, email
                [emailSent: true, registerCommand: registerCommand1]
                redirect(action: "SoyYo",params: [ emailSent: true])

            } else {
                redirectVerifyRegistration(uiRegistrationCodeStrategy.verifyRegistration(registrationCode1.token))
            }
    }


    def PorTelefono() {
        String username = params.user
        String codPais = params.codPais
        String numero = params.numero

        User user2 = User.findByUsername(username)
        String email = user2.email
        /*if (!form.validate()) {
            render view: 'index', model: [form: form]
            return
        }*/

        if (registerService.saveUser(email,numero,codPais,username)) {
            redirect controller: 'login'
        } else {
            flash.error = "¡Oh, oh, hubo algún problema para enviar su código, intente de nuevo !"
            redirect action: 'SoyYo'
        }
    }

    def verify()
    {

    }

    def verifyCode()
    {
        if (!params.code) {
            flash.error = "Por favor, ingrese el código"
        }
        /*if(springSecurityService.principal.phoneNumber == null)
        {
            flash.error = "No tiene un teléono asociado, por favor ingrese uno"
            [NoPhone: true]
            redirect(action: 'verify', params: [ Nophone: true,user:springSecurityService.principal.username,email:springSecurityService.principal.email])

        }*/

        if (registerService.verifyCode(springSecurityService.principal.username, params.code)) {
            session.verified = Boolean.TRUE
            redirect view: '/'
        } else {
            flash.error = "Cödigo Incorrecto!"
            redirect action: 'verify'
        }
    }

    def resendVerificationCode() {
        registerService.sendVerificationCode(springSecurityService.principal.username)
        redirect action: 'verify'
    }

    def resendVerificationCodeViaCall() {
        registerService.sendVerificationCodeByCall(springSecurityService.principal.username)
        redirect action: 'verify'
    }

    def oneTouchAuthenticationRequest() {
        String uuid = registerService.requestOneTimeAuthentication(springSecurityService.principal.username)
        session.uuid = uuid;
        redirect action: 'verify'
    }

    def oneTouchCallback() {
        brokerMessagingTemplate.convertAndSend "/topic/checkOTStatus", "hello from service! ${new Date().getTime()}"
        render contentType: "text/json", text: [status: 'success'] as JSON
    }

    def checkOTStatus() {
        String uuid = session.uuid
        if (uuid) {
            String status = registerService.checkOTStatus(session.uuid)
            if (status == 'approved') {
                session.verified = Boolean.TRUE
                render contentType: "text/json", text: [status: 'approved', url: g.createLink(controller: '/')] as JSON
            } else if (status == 'denied') {
                render contentType: "text/json", text: [status: 'denied', message: 'El usuarior rechazó'] as JSON
            } else {
                render contentType: "text/json", text: [status: status] as JSON
            }
        } else {
            render contentType: "text/json", text: [status: 'error'] as JSON
        }
    }


}
