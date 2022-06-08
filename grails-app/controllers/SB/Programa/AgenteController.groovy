package SB.Programa

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AgenteController {

    AgenteService agenteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond agenteService.list(params), model:[agenteCount: agenteService.count()]
    }

    def show(Long id) {
        respond agenteService.get(id)
    }

    def create() {
        respond new Agente(params)
    }

    def save(Agente agente) {
        if (agente == null) {
            notFound()
            return
        }

        try {
            agenteService.save(agente)
        } catch (ValidationException e) {
            respond agente.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'agente.label', default: 'Agente'), agente.id])
                redirect agente
            }
            '*' { respond agente, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond agenteService.get(id)
    }

    def update(Agente agente) {
        if (agente == null) {
            notFound()
            return
        }

        try {
            agenteService.save(agente)
        } catch (ValidationException e) {
            respond agente.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'agente.label', default: 'Agente'), agente.id])
                redirect agente
            }
            '*'{ respond agente, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        agenteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'agente.label', default: 'Agente'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'agente.label', default: 'Agente'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
