package prueba

import grails.gorm.services.Service

@Service(Post_comment)
interface Post_commentService {

    Post_comment get(Serializable id)

    List<Post_comment> list(Map args)

    Long count()

    void delete(Serializable id)

    Post_comment save(Post_comment post_comment)

}