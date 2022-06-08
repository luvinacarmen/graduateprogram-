package ca.formacao

import grails.gorm.services.Service

@Service(Mensagem)
interface MensagemService {

    Mensagem get(Serializable id)

    List<Mensagem> list(Map args)

    Long count()

    void delete(Serializable id)

    Mensagem save(Mensagem mensagem)

}