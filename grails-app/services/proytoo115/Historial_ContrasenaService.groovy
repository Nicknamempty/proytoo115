package proytoo115

import grails.gorm.services.Service

@Service(Historial_Contrasena)
interface Historial_ContrasenaService {

    Historial_Contrasena get(Serializable id)

    List<Historial_Contrasena> list(Map args)

    Long count()

    void delete(Serializable id)

    Historial_Contrasena save(Historial_Contrasena historial_Contrasena)

}