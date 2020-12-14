package proytoo115

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class NuevoUsuarioInterceptorSpec extends Specification implements InterceptorUnitTest<NuevoUsuarioInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test nuevoUsuario interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"nuevoUsuario")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
