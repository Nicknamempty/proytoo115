package proytoo115

class UnidadOrganizacional {

    int nivel
    String nombreUnidad
    static belongsTo = [ subUnidadOrganizacional: UnidadOrganizacional ]
    static mappedBy = [nivel: "none", nombreUnidad: "none"]
    static constraints = {
        nivel min: 0
        nombreUnidad size: 3.. 100, unique:true
        subUnidadOrganizacional nullable: true
    }
    static mapping = {
        version false
    }
    String toString() {
        nombreUnidad
    }
}
