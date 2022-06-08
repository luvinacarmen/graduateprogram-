package ca.formacao

import grails.gorm.services.Service

@Service(Processo)
interface ProcessoService {

    Processo get(Serializable id)

    List<Processo> list(Map args)

    Long count()

    void delete(Serializable id)

    Processo save(Processo processo)

}