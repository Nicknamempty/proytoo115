package proytoo115

class Empleado {
    def Direccion direccion
    static belongsTo = [Direccion]
    String nombre
    String apellido
    String dui
    String nit
    String isss
    String nup
    String genero
    String estadoCivil
    String countryCode
    String phoneNumber
    String email



    static constraints = {
        nombre size: 3..100
        apellido size: 3..100
        dui size: 10..10
        nit size: 17..17
        isss size: 3..100
        nup size: 3..100
        genero size: 1..200
        estadoCivil size: 5..200
        direccion nullable: false
        countryCode nullable: true
        phoneNumber nullable: true
    }
    @Override
    String toString() {
        nombre + " " + apellido
    }
}
