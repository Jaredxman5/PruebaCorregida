package practica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostCommentController {

    PostCommentService postCommentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond postCommentService.list(params), model:[postCommentCount: postCommentService.count()]
    }

    def show(Long id) {
        respond postCommentService.get(id)
    }

    def create() {
        respond new PostComment(params)
    }

    def save(PostComment postComment) {
        if (postComment == null) {
            notFound()
            return
        }

        try {
            postCommentService.save(postComment)
        } catch (ValidationException e) {
            respond postComment.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'postComment.label', default: 'PostComment'), postComment.id])
                redirect postComment
            }
            '*' { respond postComment, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond postCommentService.get(id)
    }

    def update(PostComment postComment) {
        if (postComment == null) {
            notFound()
            return
        }

        try {
            postCommentService.save(postComment)
        } catch (ValidationException e) {
            respond postComment.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'postComment.label', default: 'PostComment'), postComment.id])
                redirect postComment
            }
            '*'{ respond postComment, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        postCommentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'postComment.label', default: 'PostComment'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'postComment.label', default: 'PostComment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
