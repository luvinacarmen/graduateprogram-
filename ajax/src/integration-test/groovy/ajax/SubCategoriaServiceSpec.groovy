package ajax

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SubCategoriaServiceSpec extends Specification {

    SubCategoriaService subCategoriaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SubCategoria(...).save(flush: true, failOnError: true)
        //new SubCategoria(...).save(flush: true, failOnError: true)
        //SubCategoria subCategoria = new SubCategoria(...).save(flush: true, failOnError: true)
        //new SubCategoria(...).save(flush: true, failOnError: true)
        //new SubCategoria(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //subCategoria.id
    }

    void "test get"() {
        setupData()

        expect:
        subCategoriaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SubCategoria> subCategoriaList = subCategoriaService.list(max: 2, offset: 2)

        then:
        subCategoriaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        subCategoriaService.count() == 5
    }

    void "test delete"() {
        Long subCategoriaId = setupData()

        expect:
        subCategoriaService.count() == 5

        when:
        subCategoriaService.delete(subCategoriaId)
        sessionFactory.currentSession.flush()

        then:
        subCategoriaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SubCategoria subCategoria = new SubCategoria()
        subCategoriaService.save(subCategoria)

        then:
        subCategoria.id != null
    }
}
