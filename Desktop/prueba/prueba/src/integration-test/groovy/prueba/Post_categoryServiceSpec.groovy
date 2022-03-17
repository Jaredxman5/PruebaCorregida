package prueba

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Post_categoryServiceSpec extends Specification {

    Post_categoryService post_categoryService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Post_category(...).save(flush: true, failOnError: true)
        //new Post_category(...).save(flush: true, failOnError: true)
        //Post_category post_category = new Post_category(...).save(flush: true, failOnError: true)
        //new Post_category(...).save(flush: true, failOnError: true)
        //new Post_category(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //post_category.id
    }

    void "test get"() {
        setupData()

        expect:
        post_categoryService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Post_category> post_categoryList = post_categoryService.list(max: 2, offset: 2)

        then:
        post_categoryList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        post_categoryService.count() == 5
    }

    void "test delete"() {
        Long post_categoryId = setupData()

        expect:
        post_categoryService.count() == 5

        when:
        post_categoryService.delete(post_categoryId)
        sessionFactory.currentSession.flush()

        then:
        post_categoryService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Post_category post_category = new Post_category()
        post_categoryService.save(post_category)

        then:
        post_category.id != null
    }
}
