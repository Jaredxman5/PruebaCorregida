package prueba

import grails.gorm.services.Service

@Service(Post_tag)
interface Post_tagService {

    Post_tag get(Serializable id)

    List<Post_tag> list(Map args)

    Long count()

    void delete(Serializable id)

    Post_tag save(Post_tag post_tag)

}