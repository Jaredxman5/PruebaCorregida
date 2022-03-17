package prueba

import grails.gorm.services.Service

@Service(Post_category)
interface Post_categoryService {

    Post_category get(Serializable id)

    List<Post_category> list(Map args)

    Long count()

    void delete(Serializable id)

    Post_category save(Post_category post_category)

}