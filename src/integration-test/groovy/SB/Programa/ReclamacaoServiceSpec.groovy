package SB.Programa

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ReclamacaoServiceSpec extends Specification {

    ReclamacaoService reclamacaoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Reclamacao(...).save(flush: true, failOnError: true)
        //new Reclamacao(...).save(flush: true, failOnError: true)
        //Reclamacao reclamacao = new Reclamacao(...).save(flush: true, failOnError: true)
        //new Reclamacao(...).save(flush: true, failOnError: true)
        //new Reclamacao(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //reclamacao.id
    }

    void "test get"() {
        setupData()

        expect:
        reclamacaoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Reclamacao> reclamacaoList = reclamacaoService.list(max: 2, offset: 2)

        then:
        reclamacaoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        reclamacaoService.count() == 5
    }

    void "test delete"() {
        Long reclamacaoId = setupData()

        expect:
        reclamacaoService.count() == 5

        when:
        reclamacaoService.delete(reclamacaoId)
        sessionFactory.currentSession.flush()

        then:
        reclamacaoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Reclamacao reclamacao = new Reclamacao()
        reclamacaoService.save(reclamacao)

        then:
        reclamacao.id != null
    }
}
