package proytoo115.co

import grails.validation.Validateable

class RegistrationForm implements Validateable {

    String username
    String email
    String password
    String password2
    String countryCode
    String phoneNumber

    static constraints = {
        username size: 5..25, blank: false
        email email: true, blank: false
        password size: 5..15, blank: false
        countryCode blank: false
        phoneNumber blank: false
    }
}
