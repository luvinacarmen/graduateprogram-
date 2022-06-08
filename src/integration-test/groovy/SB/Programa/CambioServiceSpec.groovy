package SB.Programa

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CambioServiceSpec extends Specification {

    CambioService cambioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Cambio(...).save(flush: true, failOnError: true)
        //new Cambio(...).save(flush: true, failOnError: true)
        //Cambio cambio = new Cambio(...).save(flush: true, failOnError: true)
        //new Cambio(...).save(flush: true, failOnError: true)
        //new Cambio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //cambio.id
    }

    void "test get"() {
        setupData()

        expect:
        cambioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Cambio> cambioList = cambioService.list(max: 2, offset: 2)

        then:
        cambioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cambioService.count() == 5
    }

    void "test delete"() {
        Long cambioId = setupData()

        expect:
        cambioService.count() == 5

        when:
        cambioService.delete(cambioId)
        sessionFactory.currentSession.flush()

        then:
        cambioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Cambio cambio = new Cambio()
        cambioService.save(cambio)

        then:
        cambio.id != null
    }
}
