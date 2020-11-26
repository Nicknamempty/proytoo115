package proytoo115

class Departamento {

    String nombreD


    static constraints = {
        nombreD unique: true, size: 3..100
        municipio nulleable: true
    }
}
