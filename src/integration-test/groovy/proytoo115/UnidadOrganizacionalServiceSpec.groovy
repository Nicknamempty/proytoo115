package proytoo115

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class UnidadOrganizacionalServiceSpec extends Specification {

    UnidadOrganizacionalService unidadOrganizacionalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new UnidadOrganizacional(...).save(flush: true, failOnError: true)
        //new UnidadOrganizacional(...).save(flush: true, failOnError: true)
        //UnidadOrganizacional unidadOrganizacional = new UnidadOrganizacional(...).save(flush: true, failOnError: true)
        //new UnidadOrganizacional(...).save(flush: true, failOnError: true)
        //new UnidadOrganizacional(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //unidadOrganizacional.id
    }

    void "test get"() {
        setupData()

        expect:
        unidadOrganizacionalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<UnidadOrganizacional> unidadOrganizacionalList = unidadOrganizacionalService.list(max: 2, offset: 2)

        then:
        unidadOrganizacionalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        unidadOrganizacionalService.count() == 5
    }

    void "test delete"() {
        Long unidadOrganizacionalId = setupData()

        expect:
        unidadOrganizacionalService.count() == 5

        when:
        unidadOrganizacionalService.delete(unidadOrganizacionalId)
        sessionFactory.currentSession.flush()

        then:
        unidadOrganizacionalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        UnidadOrganizacional unidadOrganizacional = new UnidadOrganizacional()
        unidadOrganizacionalService.save(unidadOrganizacional)

        then:
        unidadOrganizacional.id != null
    }
}
