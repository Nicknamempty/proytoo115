package proytoo115

class Direccion {

    String calle
    String avenida
    String colonia
    int numeroCasa

    static constraints = {
        calle size: 3.. 100
        avenida size: 3.. 100
        colonia size: 3.. 100
        numeroCasa min: 1
    }

    static mapping = {
        version false
    }
    String toString() {
        colonia + " " + avenida+" " +avenida + " " +numeroCasa
    }
}
