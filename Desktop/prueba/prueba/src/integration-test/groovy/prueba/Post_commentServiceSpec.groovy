package prueba

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Post_commentServiceSpec extends Specification {

    Post_commentService post_commentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Post_comment(...).save(flush: true, failOnError: true)
        //new Post_comment(...).save(flush: true, failOnError: true)
        //Post_comment post_comment = new Post_comment(...).save(flush: true, failOnError: true)
        //new Post_comment(...).save(flush: true, failOnError: true)
        //new Post_comment(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //post_comment.id
    }

    void "test get"() {
        setupData()

        expect:
        post_commentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Post_comment> post_commentList = post_commentService.list(max: 2, offset: 2)

        then:
        post_commentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        post_commentService.count() == 5
    }

    void "test delete"() {
        Long post_commentId = setupData()

        expect:
        post_commentService.count() == 5

        when:
        post_commentService.delete(post_commentId)
        sessionFactory.currentSession.flush()

        then:
        post_commentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Post_comment post_comment = new Post_comment()
        post_commentService.save(post_comment)

        then:
        post_comment.id != null
    }
}
