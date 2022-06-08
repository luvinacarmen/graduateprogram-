package SB.Programa

import grails.gorm.services.Service

@Service(Reclamacao)
interface ReclamacaoService {

    Reclamacao get(Serializable id)

    List<Reclamacao> list(Map args)

    Long count()

    void delete(Serializable id)

    Reclamacao save(Reclamacao reclamacao)

}