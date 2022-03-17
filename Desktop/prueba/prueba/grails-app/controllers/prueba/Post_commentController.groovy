package prueba

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Post_commentController {

    Post_commentService post_commentService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond post_commentService.list(params), model:[post_commentCount: post_commentService.count()]
    }

    def show(Long id) {
        respond post_commentService.get(id)
    }

    def create() {
        respond new Post_comment(params)
    }

    def save(Post_comment post_comment) {
        if (post_comment == null) {
            notFound()
            return
        }

        try {
            post_commentService.save(post_comment)
        } catch (ValidationException e) {
            respond post_comment.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'post_comment.label', default: 'Post_comment'), post_comment.id])
                redirect post_comment
            }
            '*' { respond post_comment, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond post_commentService.get(id)
    }

    def update(Post_comment post_comment) {
        if (post_comment == null) {
            notFound()
            return
        }

        try {
            post_commentService.save(post_comment)
        } catch (ValidationException e) {
            respond post_comment.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'post_comment.label', default: 'Post_comment'), post_comment.id])
                redirect post_comment
            }
            '*'{ respond post_comment, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        post_commentService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'post_comment.label', default: 'Post_comment'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'post_comment.label', default: 'Post_comment'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
