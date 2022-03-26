package practica

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostCategoryController {

    PostCategoryService postCategoryService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond postCategoryService.list(params), model:[postCategoryCount: postCategoryService.count()]
    }

    def show(Long id) {
        respond postCategoryService.get(id)
    }

    def create() {
        respond new PostCategory(params)
    }

    def save(PostCategory postCategory) {
        if (postCategory == null) {
            notFound()
            return
        }

        try {
            postCategoryService.save(postCategory)
        } catch (ValidationException e) {
            respond postCategory.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'postCategory.label', default: 'PostCategory'), postCategory.id])
                redirect postCategory
            }
            '*' { respond postCategory, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond postCategoryService.get(id)
    }

    def update(PostCategory postCategory) {
        if (postCategory == null) {
            notFound()
            return
        }

        try {
            postCategoryService.save(postCategory)
        } catch (ValidationException e) {
            respond postCategory.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'postCategory.label', default: 'PostCategory'), postCategory.id])
                redirect postCategory
            }
            '*'{ respond postCategory, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        postCategoryService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'postCategory.label', default: 'PostCategory'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'postCategory.label', default: 'PostCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
