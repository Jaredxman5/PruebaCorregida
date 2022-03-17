package prueba

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Post_metaController {

    Post_metaService post_metaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond post_metaService.list(params), model:[post_metaCount: post_metaService.count()]
    }

    def show(Long id) {
        respond post_metaService.get(id)
    }

    def create() {
        respond new Post_meta(params)
    }

    def save(Post_meta post_meta) {
        if (post_meta == null) {
            notFound()
            return
        }

        try {
            post_metaService.save(post_meta)
        } catch (ValidationException e) {
            respond post_meta.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'post_meta.label', default: 'Post_meta'), post_meta.id])
                redirect post_meta
            }
            '*' { respond post_meta, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond post_metaService.get(id)
    }

    def update(Post_meta post_meta) {
        if (post_meta == null) {
            notFound()
            return
        }

        try {
            post_metaService.save(post_meta)
        } catch (ValidationException e) {
            respond post_meta.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'post_meta.label', default: 'Post_meta'), post_meta.id])
                redirect post_meta
            }
            '*'{ respond post_meta, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        post_metaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'post_meta.label', default: 'Post_meta'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'post_meta.label', default: 'Post_meta'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
