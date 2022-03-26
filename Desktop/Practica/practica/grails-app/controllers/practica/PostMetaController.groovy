package practica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostMetaController {

    PostMetaService postMetaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond postMetaService.list(params), model:[postMetaCount: postMetaService.count()]
    }

    def show(Long id) {
        respond postMetaService.get(id)
    }

    def create() {
        respond new PostMeta(params)
    }

    def save(PostMeta postMeta) {
        if (postMeta == null) {
            notFound()
            return
        }

        try {
            postMetaService.save(postMeta)
        } catch (ValidationException e) {
            respond postMeta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'postMeta.label', default: 'PostMeta'), postMeta.id])
                redirect postMeta
            }
            '*' { respond postMeta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond postMetaService.get(id)
    }

    def update(PostMeta postMeta) {
        if (postMeta == null) {
            notFound()
            return
        }

        try {
            postMetaService.save(postMeta)
        } catch (ValidationException e) {
            respond postMeta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'postMeta.label', default: 'PostMeta'), postMeta.id])
                redirect postMeta
            }
            '*'{ respond postMeta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        postMetaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'postMeta.label', default: 'PostMeta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'postMeta.label', default: 'PostMeta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
