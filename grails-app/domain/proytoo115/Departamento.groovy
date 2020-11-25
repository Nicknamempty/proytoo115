package proytoo115

class Departamento {

    static hasMany = [municipio: Municipio]
    String nombreD


    static constraints = {
        nombreD  unique: true,size:3..100
        municipio nulleable: true
    }
}
