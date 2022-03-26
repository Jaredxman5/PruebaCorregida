package practica

import grails.gorm.services.Service

@Service(PostTag)
interface PostTagService {

    PostTag get(Serializable id)

    List<PostTag> list(Map args)

    Long count()

    void delete(Serializable id)

    PostTag save(PostTag postTag)

}