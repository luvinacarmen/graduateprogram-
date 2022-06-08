package ajax

import grails.gorm.services.Service

@Service(SubCategoria)
interface SubCategoriaService {

    SubCategoria get(Serializable id)

    List<SubCategoria> list(Map args)

    Long count()

    void delete(Serializable id)

    SubCategoria save(SubCategoria subCategoria)

}