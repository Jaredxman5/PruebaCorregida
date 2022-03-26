package practica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PostTagServiceSpec extends Specification {

    PostTagService postTagService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PostTag(...).save(flush: true, failOnError: true)
        //new PostTag(...).save(flush: true, failOnError: true)
        //PostTag postTag = new PostTag(...).save(flush: true, failOnError: true)
        //new PostTag(...).save(flush: true, failOnError: true)
        //new PostTag(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //postTag.id
    }

    void "test get"() {
        setupData()

        expect:
        postTagService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PostTag> postTagList = postTagService.list(max: 2, offset: 2)

        then:
        postTagList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        postTagService.count() == 5
    }

    void "test delete"() {
        Long postTagId = setupData()

        expect:
        postTagService.count() == 5

        when:
        postTagService.delete(postTagId)
        sessionFactory.currentSession.flush()

        then:
        postTagService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PostTag postTag = new PostTag()
        postTagService.save(postTag)

        then:
        postTag.id != null
    }
}
