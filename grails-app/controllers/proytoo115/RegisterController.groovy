package proytoo115

import grails.converters.JSON
import grails.gsp.PageRenderer
import grails.plugin.springsecurity.ui.CommandObject
import grails.plugin.springsecurity.ui.ForgotPasswordCommand
import grails.plugin.springsecurity.ui.RegisterCommand


import grails.plugin.springsecurity.ui.RegistrationCode
import grails.plugin.springsecurity.ui.ResetPasswordCommand
import grails.plugin.springsecurity.ui.strategy.PropertiesStrategy
import org.apache.commons.lang3.RandomStringUtils
import org.springframework.context.MessageSource

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {
    def springSecurityService
    def registerService

    /** Dependency injection for the 'uiPropertiesStrategy' bean. */
    PropertiesStrategy uiPropertiesStrategy

    String serverURL

    PageRenderer groovyPageRenderer
    MessageSource messageSource

    static final String EMAIL_LAYOUT = "/layouts/email"
    static final String FORGOT_PASSWORD_TEMPLATE = "/register/_forgotPasswordMail"
    static final String VERIFY_REGISTRATION_TEMPLATE = "/register/_verifyRegistrationMail"

    def Registro()
    {String xd = params.user
        Empleado empleado = Empleado.findByDui(xd)
        String charset = (('A'..'Z') + ('0'..'9')).join()
        Integer length = 9
        String randomString = RandomStringUtils.random(length, charset.toCharArray())
        RegisterCommand registerCommand1 = new RegisterCommand()
        registerCommand1.username = empleado.dui
        registerCommand1.email = empleado.email
        registerCommand1.password = randomString
        registerCommand1.password2 = randomString
        def user = uiRegistrationCodeStrategy.createUser(registerCommand1)
        RegistrationCode registrationCode = uiRegistrationCodeStrategy.register(user, registerCommand1.password)
        User userx = User.findByUsername(empleado.dui)
        userx.newUser=true

        if (registerService.saveUser(empleado.email,empleado.phoneNumber,empleado.countryCode,empleado.dui)) {
            //
            sendMail {
                to empleado.email
                subject "Nuevas Credenciales Across Company"
                text "A continuación obtendrá las credenciales con las que podrá ingresar a su cuenta: ${userx.username} clave: ${randomString}"
            }
            redirect (uri:'/')
        } else {
            flash.error = "¡Oh, oh, hubo algún problema para enviar su código, intente de nuevo !"
           // redirect action: 'SoyYo'
        }

    }


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
    def forgotPassword(ForgotPasswordCommand forgotPasswordCommand) {

        if (!request.post) {
            ForgotPasswordCommand fpc = new ForgotPasswordCommand()
            return [forgotPasswordCommand: fpc]
        }
        withForm {
            if (forgotPasswordCommand.hasErrors()) {

                return [forgotPasswordCommand: forgotPasswordCommand]
            }
            def user = findUserByUsername(forgotPasswordCommand.username)
            if(springSecurityService.isLoggedIn())
            {
                User userx = User.findByUsername(forgotPasswordCommand.username)
                if(userx.newUser)
                {
                    redirect uri: processForgotPasswordEmail(forgotPasswordCommand, user)
                }
            } else {


                    if (forgotPasswordExtraValidation && forgotPasswordExtraValidation.size() > 0 && forgotPasswordExtraValidationDomainClassName) {
                        redirect uri: generateLink('securityQuestions', [username: forgotPasswordCommand.username])
                    } else {
                        if (requireForgotPassEmailValidation) {
                            processForgotPasswordEmail(forgotPasswordCommand, user)
                        } else {
                            redirect uri: processForgotPasswordEmail(forgotPasswordCommand, user)
                        }
                    }
                }
        }.invalidToken {
            flash.message = "Invalid Form Submission"
            redirect(controller: "login", action: "auth")
        }
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


        if (registerService.verifyCode(springSecurityService.principal.username, params.code)) {
            session.verified = Boolean.TRUE
            redirect(uri:'/')
        } else {
            flash.error = "Código Incorrecto!"
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
 def processForgotPasswordEmail(forgotPasswordCommand,user){
        if(springSecurityService.isLoggedIn())
        {
            User userx = User.findByUsername(forgotPasswordCommand.username)
            if(userx.newUser) {
                return generateLink('resetPassword', [t: uiRegistrationCodeStrategy.sendForgotPasswordMail(forgotPasswordCommand.username)?.token])
            }
            }else {


            if (requireForgotPassEmailValidation) {
                String email = uiPropertiesStrategy.getProperty(user, 'email')
                if (!email) {
                    forgotPasswordCommand.errors.rejectValue 'username', 'spring.security.ui.forgotPassword.noEmail'
                    return [forgotPasswordCommand: forgotPasswordCommand]
                }
                uiRegistrationCodeStrategy.sendForgotPasswordMail(
                        forgotPasswordCommand.username, email) { String registrationCodeToken ->

                    String url = generateLink('resetPassword', [t: registrationCodeToken])
                    String body = forgotPasswordEmailBody

                    if (!body) {
                        body = renderEmail(
                                "/register/_forgotPasswordMail",
                                [
                                        url     : url,
                                        username: user.username
                                ]
                        )
                    } else if (body.contains('$')) {
                        body = evaluate(body, [user: user, url: url])
                    }

                    body
                }
                [emailSent: true, forgotPasswordCommand: forgotPasswordCommand]
            } else {
                return generateLink('resetPassword', [t: uiRegistrationCodeStrategy.sendForgotPasswordMail(forgotPasswordCommand.username)?.token])
            }
        }
    }

    def resetPassword(ResetPasswordCommand resetPasswordCommand) {

        String token = params.t

        def registrationCode = token ? RegistrationCode.findByToken(token) : null
        if (!registrationCode) {
            flash.error = message(code: 'spring.security.ui.resetPassword.badCode')
            redirect uri: successHandlerDefaultTargetUrl
            return
        }

        if (!request.post) {
            return [token: token, resetPasswordCommand: new ResetPasswordCommand()]
        }

        resetPasswordCommand.username = registrationCode.username
        resetPasswordCommand.validate()
        if (resetPasswordCommand.hasErrors()) {
            return [token: token, resetPasswordCommand: resetPasswordCommand]
        }

        def user = uiRegistrationCodeStrategy.resetPassword(resetPasswordCommand, registrationCode)

        if(springSecurityService.isLoggedIn())
                {
                registerService.NuevoUsuario(registrationCode.username)
                }

        if (user.hasErrors()) {
            // expected to be handled already by ErrorsStrategy.handleValidationErrors
        }

        flash.message = message(code: 'spring.security.ui.resetPassword.success')

        redirect uri: registerPostResetUrl ?: successHandlerDefaultTargetUrl
    }

}

