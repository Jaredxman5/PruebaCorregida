package prueba

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Post_tagServiceSpec extends Specification {

    Post_tagService post_tagService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Post_tag(...).save(flush: true, failOnError: true)
        //new Post_tag(...).save(flush: true, failOnError: true)
        //Post_tag post_tag = new Post_tag(...).save(flush: true, failOnError: true)
        //new Post_tag(...).save(flush: true, failOnError: true)
        //new Post_tag(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //post_tag.id
    }

    void "test get"() {
        setupData()

        expect:
        post_tagService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Post_tag> post_tagList = post_tagService.list(max: 2, offset: 2)

        then:
        post_tagList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        post_tagService.count() == 5
    }

    void "test delete"() {
        Long post_tagId = setupData()

        expect:
        post_tagService.count() == 5

        when:
        post_tagService.delete(post_tagId)
        sessionFactory.currentSession.flush()

        then:
        post_tagService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Post_tag post_tag = new Post_tag()
        post_tagService.save(post_tag)

        then:
        post_tag.id != null
    }
}
