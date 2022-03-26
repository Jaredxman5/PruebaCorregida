package practica

import grails.gorm.services.Service

@Service(PostComment)
interface PostCommentService {

    PostComment get(Serializable id)

    List<PostComment> list(Map args)

    Long count()

    void delete(Serializable id)

    PostComment save(PostComment postComment)

}