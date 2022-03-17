package prueba

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Post_metaServiceSpec extends Specification {

    Post_metaService post_metaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Post_meta(...).save(flush: true, failOnError: true)
        //new Post_meta(...).save(flush: true, failOnError: true)
        //Post_meta post_meta = new Post_meta(...).save(flush: true, failOnError: true)
        //new Post_meta(...).save(flush: true, failOnError: true)
        //new Post_meta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //post_meta.id
    }

    void "test get"() {
        setupData()

        expect:
        post_metaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Post_meta> post_metaList = post_metaService.list(max: 2, offset: 2)

        then:
        post_metaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        post_metaService.count() == 5
    }

    void "test delete"() {
        Long post_metaId = setupData()

        expect:
        post_metaService.count() == 5

        when:
        post_metaService.delete(post_metaId)
        sessionFactory.currentSession.flush()

        then:
        post_metaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Post_meta post_meta = new Post_meta()
        post_metaService.save(post_meta)

        then:
        post_meta.id != null
    }
}
