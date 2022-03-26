package practica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PostCommentServiceSpec extends Specification {

    PostCommentService postCommentService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PostComment(...).save(flush: true, failOnError: true)
        //new PostComment(...).save(flush: true, failOnError: true)
        //PostComment postComment = new PostComment(...).save(flush: true, failOnError: true)
        //new PostComment(...).save(flush: true, failOnError: true)
        //new PostComment(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //postComment.id
    }

    void "test get"() {
        setupData()

        expect:
        postCommentService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PostComment> postCommentList = postCommentService.list(max: 2, offset: 2)

        then:
        postCommentList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        postCommentService.count() == 5
    }

    void "test delete"() {
        Long postCommentId = setupData()

        expect:
        postCommentService.count() == 5

        when:
        postCommentService.delete(postCommentId)
        sessionFactory.currentSession.flush()

        then:
        postCommentService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PostComment postComment = new PostComment()
        postCommentService.save(postComment)

        then:
        postComment.id != null
    }
}
