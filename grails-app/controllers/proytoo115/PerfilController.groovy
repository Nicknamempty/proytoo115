package  proytoo115

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.validation.ValidationException

class PerfilController extends grails.plugin.springsecurity.ui.AbstractS2UiDomainController {

     PerfilService perfilService
    
     static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
     static defaultAction = 'index'

     def search() { redirect action: "index", method: "GET" }

    protected Class<?> getClazz() { Perfil }
    protected String getClassLabelCode() { 'perfil.label' }
    protected Map model(perfil, String action) {
                    [ perfil: perfil]
    }
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.offset = Math.max(params.offset ? params.int('offset') : 0, 0)
        def model = [:]
        model.results = perfilService.list(params)
        model.totalCount = perfilService.count()
        addQueryParamsToModelForPaging(model,
          'myQuestion1','myAnswer1','myQuestion2','myAnswer2','myQuestion3','myAnswer3','myQuestion4','myAnswer4',
        'id', 'user.id'
        )
        render view: 'index', model: model
    }
    
    def show(Long id) {
        redirect action: 'edit', id: id
    }
    
    def create() {
        respond new Perfil(params), model : ['users': User.list(),'lookupProp':SpringSecurityUtils.securityConfig.userLookup.usernamePropertyName]
    }
    
    def save(Perfil perfil) {
        withForm {
            if (perfil == null) {
                notFound()
                return
            }

            try {
                perfilService.save(perfil)
            } catch (ValidationException e) {
                respond perfil.errors, view:'create', model : ['users': User.list(),'lookupProp':SpringSecurityUtils.securityConfig.userLookup.usernamePropertyName]
                return
            }

            request.withFormat {
                form multipartForm {
                    flashCreated(perfil.id)
                    redirect action:"index", method:"GET"
                }
                '*' { respond perfil, [status: CREATED] }
            }
        }.invalidToken {
            doSaveWithInvalidToken()
        }
    }
    
    def edit(Long id) {
        respond perfilService.get(id), model : ['users': User.list(),'lookupProp':SpringSecurityUtils.securityConfig.userLookup.usernamePropertyName]
    }
    
    def update(Perfil perfil) {
        withForm {
            if (perfil == null) {
                notFound()
                return
            }

            try {
                perfilService.save(perfil)
            } catch (ValidationException e) {
                respond perfil.errors, view:'edit'
                return
            }

            request.withFormat {
                form multipartForm {
                   flashUpdated()
                   redirect action:"index", method:"GET"
                }
                '*'{ respond perfil, [status: OK] }
            }
        }.invalidToken {
             doUpdateWithInvalidToken()
        }
    }
    
    def delete(Long id) {
        withForm {
            if (id == null) {
                notFound()
                return
            }

            perfilService.delete(id)

            request.withFormat {
                form multipartForm {
                    flashDeleted()
                    redirect action:"index", method:"GET"
                }
                '*'{ render status: NO_CONTENT }
            }
        }.invalidToken {
            doDeleteWithInvalidToken()
        }
    }
    
    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flashNotFound()
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}