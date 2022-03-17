package prueba

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Post_tagController {

    Post_tagService post_tagService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond post_tagService.list(params), model:[post_tagCount: post_tagService.count()]
    }

    def show(Long id) {
        respond post_tagService.get(id)
    }

    def create() {
        respond new Post_tag(params)
    }

    def save(Post_tag post_tag) {
        if (post_tag == null) {
            notFound()
            return
        }

        try {
            post_tagServic  e.save(post_tag)
        } catch (ValidationException e) {
            respond post_tag.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'post_tag.label', default: 'Post_tag'), post_tag.id])
                redirect post_tag
            }
            '*' { respond post_tag, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond post_tagService.get(id)
    }

    def update(Post_tag post_tag) {
        if (post_tag == null) {
            notFound()
            return
        }

        try {
            post_tagService.save(post_tag)
        } catch (ValidationException e) {
            respond post_tag.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'post_tag.label', default: 'Post_tag'), post_tag.id])
                redirect post_tag
            }
            '*'{ respond post_tag, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        post_tagService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'post_tag.label', default: 'Post_tag'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'post_tag.label', default: 'Post_tag'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
