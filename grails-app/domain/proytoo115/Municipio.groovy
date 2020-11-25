package proytoo115

class Municipio {

    static belongsTo = [departamento : Departamento]
    String nombreM




    static constraints = {
        nombreM unique:true, size: 3..100
        departamento nullable: true

    }
}
