package proytoo115

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON

class EmpleadoController {

    EmpleadoService empleadoService
    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        String genero = params.genero

        if(genero!=null)
        {
            List<Empleado> empleadoList = Empleado.findAllByGenero(genero)
            respond empleadoList, model:[empleadoCount: empleadoService.count()]
            return
        }
        respond empleadoService.list(params), model:[empleadoCount: empleadoService.count()]
    }

    def show(Long id) {

        respond empleadoService.get(id)
    }
    def Personal() {

        User userx = User.findByUsername(springSecurityService.principal.username)
        Empleado empleado  = Empleado.findByEmail(userx.email)
        respond empleadoService.get(empleado.id)
    }

    def create() {
        def departamentos = Departamento.getAll() //Obetener todos los departamentos para el select box
        def municipios = Municipio.getAll() // obtener todos los municipios para el select box
        respond new Empleado(params) , model: [departamentos:departamentos, municipios:municipios as JSON]
        //Mando a la vistas todos los departamentos y municipios. Municipio en formato JSON
    }

    def save(Empleado empleado) {
        if (empleado == null) {
            notFound()
            return
        }

        try {
            empleadoService.save(empleado)
        } catch (ValidationException e) {
            def departamentos = Departamento.getAll()
            def municipios = Municipio.getAll()
            respond empleado.errors, view:'create', model: [departamentos:departamentos, municipios:municipios as JSON]
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'empleado.label', default: 'Empleado'), empleado.id])
                redirect(controller: 'register',action: "Registro",params: [user: empleado.dui])
            }
            '*' { respond empleado, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def departamentos = Departamento.getAll() //Obetener todos los departamentos para el select box
        def municipios = Municipio.getAll() // obtener todos los municipios para el select box
        respond empleadoService.get(id), model: [departamentos:departamentos, municipios:municipios as JSON]
//        //Mando a la vistas todos los departamentos y municipios. Municipio en formato JSON
    }

    def update(Empleado empleado) {
        if (empleado == null) {
            notFound()
            return
        }

        try {
            empleadoService.save(empleado)
        } catch (ValidationException e) {
            respond empleado.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'empleado.label', default: 'Empleado'), empleado.id])
                redirect empleado
            }
            '*'{ respond empleado, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        empleadoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'empleado.label', default: 'Empleado'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'empleado.label', default: 'Empleado'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
