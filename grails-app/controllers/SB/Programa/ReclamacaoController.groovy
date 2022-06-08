package SB.Programa

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ReclamacaoController {

    ReclamacaoService reclamacaoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond reclamacaoService.list(params), model:[reclamacaoCount: reclamacaoService.count()]
    }

    def show(Long id) {
        respond reclamacaoService.get(id)
    }

    def create() {
        respond new Reclamacao(params)
    }

    def save(Reclamacao reclamacao) {
        if (reclamacao == null) {
            notFound()
            return
        }

        try {
            reclamacaoService.save(reclamacao)
        } catch (ValidationException e) {
            respond reclamacao.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), reclamacao.id])
                redirect reclamacao
            }
            '*' { respond reclamacao, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond reclamacaoService.get(id)
    }

    def update(Reclamacao reclamacao) {
        if (reclamacao == null) {
            notFound()
            return
        }

        try {
            reclamacaoService.save(reclamacao)
        } catch (ValidationException e) {
            respond reclamacao.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), reclamacao.id])
                redirect reclamacao
            }
            '*'{ respond reclamacao, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        reclamacaoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
