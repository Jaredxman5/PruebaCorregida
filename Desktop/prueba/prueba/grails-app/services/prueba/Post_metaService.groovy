package prueba

import grails.gorm.services.Service

@Service(Post_meta)
interface Post_metaService {

    Post_meta get(Serializable id)

    List<Post_meta> list(Map args)

    Long count()

    void delete(Serializable id)

    Post_meta save(Post_meta post_meta)

}