package SB.Programa

import grails.gorm.services.Service

@Service(Cambio)
interface CambioService {

    Cambio get(Serializable id)

    List<Cambio> list(Map args)

    Long count()

    void delete(Serializable id)

    Cambio save(Cambio cambio)

}