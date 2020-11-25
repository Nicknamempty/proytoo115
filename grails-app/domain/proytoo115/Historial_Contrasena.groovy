package proytoo115

class Historial_Contrasena {

    static belongsTo = [usuario : User]
    String contrasena
    Date fechaCambio = new Date()

    static constraints = {

    }
}

