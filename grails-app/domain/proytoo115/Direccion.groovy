package proytoo115

class Direccion {
    String calle
    String avenida
    String colonia
    int numeroCasa
    Municipio municipio

    static constraints = {
        calle size: 3.. 100
        avenida size: 3.. 100
        colonia size: 3.. 100
        numeroCasa min: 1
        municipio nullable: true
    }

    static mapping = {
        version false
    }
    String toString() {
        "colonia:"+ colonia + ", avenida:" + avenida+", calle:" +calle + " Casa:" +numeroCasa
    }
}
