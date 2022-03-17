package prueba

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class Post_categoryController {

    Post_categoryService post_categoryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond post_categoryService.list(params), model:[post_categoryCount: post_categoryService.count()]
    }

    def show(Long id) {
        respond post_categoryService.get(id)
    }

    def create() {
        respond new Post_category(params)
    }

    def save(Post_category post_category) {
        if (post_category == null) {
            notFound()
            return
        }

        try {
            post_categoryService.save(post_category)
        } catch (ValidationException e) {
            respond post_category.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'post_category.label', default: 'Post_category'), post_category.id])
                redirect post_category
            }
            '*' { respond post_category, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond post_categoryService.get(id)
    }

    def update(Post_category post_category) {
        if (post_category == null) {
            notFound()
            return
        }

        try {
            post_categoryService.save(post_category)
        } catch (ValidationException e) {
            respond post_category.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'post_category.label', default: 'Post_category'), post_category.id])
                redirect post_category
            }
            '*'{ respond post_category, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        post_categoryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'post_category.label', default: 'Post_category'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'post_category.label', default: 'Post_category'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
