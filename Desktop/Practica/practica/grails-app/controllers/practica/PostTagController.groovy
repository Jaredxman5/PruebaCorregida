package practica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostTagController {

    PostTagService postTagService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond postTagService.list(params), model:[postTagCount: postTagService.count()]
    }

    def show(Long id) {
        respond postTagService.get(id)
    }

    def create() {
        respond new PostTag(params)
    }

    def save(PostTag postTag) {
        if (postTag == null) {
            notFound()
            return
        }

        try {
            postTagService.save(postTag)
        } catch (ValidationException e) {
            respond postTag.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'postTag.label', default: 'PostTag'), postTag.id])
                redirect postTag
            }
            '*' { respond postTag, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond postTagService.get(id)
    }

    def update(PostTag postTag) {
        if (postTag == null) {
            notFound()
            return
        }

        try {
            postTagService.save(postTag)
        } catch (ValidationException e) {
            respond postTag.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'postTag.label', default: 'PostTag'), postTag.id])
                redirect postTag
            }
            '*'{ respond postTag, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        postTagService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'postTag.label', default: 'PostTag'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'postTag.label', default: 'PostTag'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
