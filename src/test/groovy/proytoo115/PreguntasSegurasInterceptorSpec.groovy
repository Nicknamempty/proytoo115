package proytoo115

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class PreguntasSegurasInterceptorSpec extends Specification implements InterceptorUnitTest<PreguntasSegurasInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test preguntasSeguras interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"preguntasSeguras")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
