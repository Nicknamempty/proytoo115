package proytoo115

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UnidadOrganizacionalController {

    UnidadOrganizacionalService unidadOrganizacionalService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond unidadOrganizacionalService.list(params), model:[unidadOrganizacionalCount: unidadOrganizacionalService.count()]
    }

    def show(Long id) {
        def subUnidad = UnidadOrganizacional.findAllByUnidadOrganizacionalSuperior(UnidadOrganizacional.findAllById(id)).toList()
        respond unidadOrganizacionalService.get(id), model: [subUnidad:subUnidad]
    }

    def create() {
        respond new UnidadOrganizacional(params)
    }

    def save(UnidadOrganizacional unidadOrganizacional) {
        if (unidadOrganizacional == null) {
            notFound()
            return
        }

        try {
            if (unidadOrganizacional.unidadOrganizacionalSuperior==null){
                unidadOrganizacional.nivel=0
            } else{
                unidadOrganizacional.nivel=unidadOrganizacional.unidadOrganizacionalSuperior.nivel+1
            }
            unidadOrganizacionalService.save(unidadOrganizacional)
        } catch (ValidationException e) {
            respond unidadOrganizacional.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'unidadOrganizacional.label', default: 'UnidadOrganizacional'), unidadOrganizacional.id])
                redirect unidadOrganizacional
            }
            '*' { respond unidadOrganizacional, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond unidadOrganizacionalService.get(id)
    }

    def update(UnidadOrganizacional unidadOrganizacional) {
        if (unidadOrganizacional == null) {
            notFound()
            return
        }

        try {
            if (unidadOrganizacional.unidadOrganizacionalSuperior==null){
                unidadOrganizacional.nivel=0
            } else{
                unidadOrganizacional.nivel=unidadOrganizacional.unidadOrganizacionalSuperior.nivel+1
            }
            unidadOrganizacionalService.save(unidadOrganizacional)
        } catch (ValidationException e) {
            respond unidadOrganizacional.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'unidadOrganizacional.label', default: 'UnidadOrganizacional'), unidadOrganizacional.id])
                redirect unidadOrganizacional
            }
            '*'{ respond unidadOrganizacional, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        unidadOrganizacionalService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'unidadOrganizacional.label', default: 'UnidadOrganizacional'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'unidadOrganizacional.label', default: 'UnidadOrganizacional'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
