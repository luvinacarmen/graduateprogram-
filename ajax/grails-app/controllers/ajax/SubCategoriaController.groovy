package ajax

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SubCategoriaController {

    SubCategoriaService subCategoriaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond subCategoriaService.list(params), model:[subCategoriaCount: subCategoriaService.count()]
    }

    def show(Long id) {
        respond subCategoriaService.get(id)
    }

    def create() {
        respond new SubCategoria(params)
    }

    def save(SubCategoria subCategoria) {
        if (subCategoria == null) {
            notFound()
            return
        }

        try {
            subCategoriaService.save(subCategoria)
        } catch (ValidationException e) {
            respond subCategoria.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), subCategoria.id])
                redirect subCategoria
            }
            '*' { respond subCategoria, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond subCategoriaService.get(id)
    }

    def update(SubCategoria subCategoria) {
        if (subCategoria == null) {
            notFound()
            return
        }

        try {
            subCategoriaService.save(subCategoria)
        } catch (ValidationException e) {
            respond subCategoria.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), subCategoria.id])
                redirect subCategoria
            }
            '*'{ respond subCategoria, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        subCategoriaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'subCategoria.label', default: 'SubCategoria'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
