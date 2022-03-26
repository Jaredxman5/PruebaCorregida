package practica

import grails.gorm.services.Service

@Service(PostMeta)
interface PostMetaService {

    PostMeta get(Serializable id)

    List<PostMeta> list(Map args)

    Long count()

    void delete(Serializable id)

    PostMeta save(PostMeta postMeta)

}