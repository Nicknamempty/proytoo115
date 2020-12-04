package proytoo115

class Departamento {
    String nombre

    static constraints = {
        nombre unique: true, size: 3..100
    }

    @Override
    String toString() {
        nombre
    }
}
