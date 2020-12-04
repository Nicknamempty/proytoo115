package proytoo115

class Municipio {
    String nombre
    Departamento departamento

    static constraints = {
        nombre unique: true, size: 3..100
        departamento nullable: true
    }

    @Override
    String toString() {
        nombre
    }
}
