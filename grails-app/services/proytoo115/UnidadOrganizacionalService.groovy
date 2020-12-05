package proytoo115

import grails.gorm.services.Service

@Service(UnidadOrganizacional)
interface UnidadOrganizacionalService {

    UnidadOrganizacional get(Serializable id)

    List<UnidadOrganizacional> list(Map args)

    Long count()

    void delete(Serializable id)

    UnidadOrganizacional save(UnidadOrganizacional unidadOrganizacional)

}