package SB.Programa

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CambioController {

    CambioService cambioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cambioService.list(params), model:[cambioCount: cambioService.count()]
    }

    def show(Long id) {
        respond cambioService.get(id)
    }

    def create() {
        respond new Cambio(params)
    }

    def save(Cambio cambio) {
        if (cambio == null) {
            notFound()
            return
        }

        try {
            cambioService.save(cambio)
        } catch (ValidationException e) {
            respond cambio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cambio.label', default: 'Cambio'), cambio.id])
                redirect cambio
            }
            '*' { respond cambio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond cambioService.get(id)
    }

    def update(Cambio cambio) {
        if (cambio == null) {
            notFound()
            return
        }

        try {
            cambioService.save(cambio)
        } catch (ValidationException e) {
            respond cambio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'cambio.label', default: 'Cambio'), cambio.id])
                redirect cambio
            }
            '*'{ respond cambio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        cambioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'cambio.label', default: 'Cambio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cambio.label', default: 'Cambio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
