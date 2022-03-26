package practica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PostCategoryServiceSpec extends Specification {

    PostCategoryService postCategoryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PostCategory(...).save(flush: true, failOnError: true)
        //new PostCategory(...).save(flush: true, failOnError: true)
        //PostCategory postCategory = new PostCategory(...).save(flush: true, failOnError: true)
        //new PostCategory(...).save(flush: true, failOnError: true)
        //new PostCategory(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //postCategory.id
    }

    void "test get"() {
        setupData()

        expect:
        postCategoryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PostCategory> postCategoryList = postCategoryService.list(max: 2, offset: 2)

        then:
        postCategoryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        postCategoryService.count() == 5
    }

    void "test delete"() {
        Long postCategoryId = setupData()

        expect:
        postCategoryService.count() == 5

        when:
        postCategoryService.delete(postCategoryId)
        sessionFactory.currentSession.flush()

        then:
        postCategoryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PostCategory postCategory = new PostCategory()
        postCategoryService.save(postCategory)

        then:
        postCategory.id != null
    }
}
