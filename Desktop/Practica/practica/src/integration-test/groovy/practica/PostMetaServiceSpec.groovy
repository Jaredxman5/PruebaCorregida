package practica

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PostMetaServiceSpec extends Specification {

    PostMetaService postMetaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PostMeta(...).save(flush: true, failOnError: true)
        //new PostMeta(...).save(flush: true, failOnError: true)
        //PostMeta postMeta = new PostMeta(...).save(flush: true, failOnError: true)
        //new PostMeta(...).save(flush: true, failOnError: true)
        //new PostMeta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //postMeta.id
    }

    void "test get"() {
        setupData()

        expect:
        postMetaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PostMeta> postMetaList = postMetaService.list(max: 2, offset: 2)

        then:
        postMetaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        postMetaService.count() == 5
    }

    void "test delete"() {
        Long postMetaId = setupData()

        expect:
        postMetaService.count() == 5

        when:
        postMetaService.delete(postMetaId)
        sessionFactory.currentSession.flush()

        then:
        postMetaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PostMeta postMeta = new PostMeta()
        postMetaService.save(postMeta)

        then:
        postMeta.id != null
    }
}
