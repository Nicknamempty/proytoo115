package proytoo115

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DireccionController {

    DireccionService direccionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond direccionService.list(params), model:[direccionCount: direccionService.count()]
    }

    def show(Long id) {
        respond direccionService.get(id)
    }

    def create() {
        respond new Direccion(params)
    }

    def save(Direccion direccion) {
        if (direccion == null) {
            notFound()
            return
        }

        try {
            direccionService.save(direccion)
        } catch (ValidationException e) {
            respond direccion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'direccion.label', default: 'Direccion'), direccion.id])
                redirect direccion
            }
            '*' { respond direccion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond direccionService.get(id)
    }

    def update(Direccion direccion) {
        if (direccion == null) {
            notFound()
            return
        }

        try {
            direccionService.save(direccion)
        } catch (ValidationException e) {
            respond direccion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'direccion.label', default: 'Direccion'), direccion.id])
                redirect direccion
            }
            '*'{ respond direccion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        direccionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'direccion.label', default: 'Direccion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'direccion.label', default: 'Direccion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
