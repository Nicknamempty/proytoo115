package proytoo115

class UnidadOrganizacional {

    int nivel
    String nombreUnidad
    static belongsTo = [ unidadOrganizacionalSuperior: UnidadOrganizacional ]
    static mappedBy = [nivel: "none", nombreUnidad: "none"]
    static constraints = {
        nivel min: 0
        nombreUnidad size: 3.. 100, unique:true
        unidadOrganizacionalSuperior nullable: true
    }
    static mapping = {
        version false
    }
    String toString() {
        nombreUnidad
    }
}
