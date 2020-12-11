package proytoo115

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.security.access.event.AbstractAuthorizationEvent
import org.springframework.security.authentication.event.AbstractAuthenticationEvent
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent
import org.springframework.security.authentication.event.AuthenticationSuccessEvent
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent

import grails.plugin.springsecurity.web.SecurityRequestHolder

import groovy.transform.CompileStatic

//import javax.jws.soap.SOAPBinding

@CompileStatic
class FailedLoginListener implements ApplicationListener<ApplicationEvent>{
    ApplicationContext applicationContext
        void onApplicationEvent(ApplicationEvent e) {
            if (e instanceof AbstractAuthenticationEvent) { //Valida si ha habido un evento
                if (e instanceof AbstractAuthenticationFailureEvent) { //Valida si el evento de error de credenciales se ha activado
                    def username = SecurityRequestHolder.request.getParameter("username").toString() //obtener el dato del campo username del login
                    println(username)
                }
            }
        }

    }

