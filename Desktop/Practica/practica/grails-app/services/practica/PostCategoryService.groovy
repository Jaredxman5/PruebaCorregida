package practica

import grails.gorm.services.Service

@Service(PostCategory)
interface PostCategoryService {

    PostCategory get(Serializable id)

    List<PostCategory> list(Map args)

    Long count()

    void delete(Serializable id)

    PostCategory save(PostCategory postCategory)

}