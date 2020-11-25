package proytoo115

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Historial_ContrasenaServiceSpec extends Specification {

    Historial_ContrasenaService historial_ContrasenaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Historial_Contrasena(...).save(flush: true, failOnError: true)
        //new Historial_Contrasena(...).save(flush: true, failOnError: true)
        //Historial_Contrasena historial_Contrasena = new Historial_Contrasena(...).save(flush: true, failOnError: true)
        //new Historial_Contrasena(...).save(flush: true, failOnError: true)
        //new Historial_Contrasena(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //historial_Contrasena.id
    }

    void "test get"() {
        setupData()

        expect:
        historial_ContrasenaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Historial_Contrasena> historial_ContrasenaList = historial_ContrasenaService.list(max: 2, offset: 2)

        then:
        historial_ContrasenaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        historial_ContrasenaService.count() == 5
    }

    void "test delete"() {
        Long historial_ContrasenaId = setupData()

        expect:
        historial_ContrasenaService.count() == 5

        when:
        historial_ContrasenaService.delete(historial_ContrasenaId)
        sessionFactory.currentSession.flush()

        then:
        historial_ContrasenaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Historial_Contrasena historial_Contrasena = new Historial_Contrasena()
        historial_ContrasenaService.save(historial_Contrasena)

        then:
        historial_Contrasena.id != null
    }
}
