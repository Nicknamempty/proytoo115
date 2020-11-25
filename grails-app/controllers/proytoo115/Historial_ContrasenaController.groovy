package proytoo115

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Historial_ContrasenaController {

    Historial_ContrasenaService historial_ContrasenaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond historial_ContrasenaService.list(params), model:[historial_ContrasenaCount: historial_ContrasenaService.count()]
    }

    def show(Long id) {
        respond historial_ContrasenaService.get(id)
    }

    def create() {
        respond new Historial_Contrasena(params)
    }

    def save(Historial_Contrasena historial_Contrasena) {
        if (historial_Contrasena == null) {
            notFound()
            return
        }

        try {
            historial_ContrasenaService.save(historial_Contrasena)
        } catch (ValidationException e) {
            respond historial_Contrasena.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'historial_Contrasena.label', default: 'Historial_Contrasena'), historial_Contrasena.id])
                redirect historial_Contrasena
            }
            '*' { respond historial_Contrasena, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond historial_ContrasenaService.get(id)
    }

    def update(Historial_Contrasena historial_Contrasena) {
        if (historial_Contrasena == null) {
            notFound()
            return
        }

        try {
            historial_ContrasenaService.save(historial_Contrasena)
        } catch (ValidationException e) {
            respond historial_Contrasena.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'historial_Contrasena.label', default: 'Historial_Contrasena'), historial_Contrasena.id])
                redirect historial_Contrasena
            }
            '*'{ respond historial_Contrasena, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        historial_ContrasenaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'historial_Contrasena.label', default: 'Historial_Contrasena'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'historial_Contrasena.label', default: 'Historial_Contrasena'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
