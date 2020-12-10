package proytoo115

import grails.testing.web.interceptor.InterceptorUnitTest
import spock.lang.Specification

class ParaAuthyInterceptorSpec extends Specification implements InterceptorUnitTest<ParaAuthyInterceptor> {

    def setup() {
    }

    def cleanup() {

    }

    void "Test paraAuthy interceptor matching"() {
        when:"A request matches the interceptor"
            withRequest(controller:"paraAuthy")

        then:"The interceptor does match"
            interceptor.doesMatch()
    }
}
