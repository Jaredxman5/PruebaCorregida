package practica

class Post {
    
    Post parent
    String title
    String metaTitle
    String slug
    String summary
    int published   
    Date createdAt=new Date()
    Date updatedAt=new Date()
    Date publishedAt=new Date()
    String content
    
    static belongsTo=[author:User]
    
    static constraints = {
        title(nullable:false,unique:true)
        metaTitle(blank:true,nullable:true)
        slug(blank:true,nullable:false)
        summary(blank:true,nullable:true)
        published(nullable:false)
        createdAt(nullable:false)
        content(blank:true,nullable:true)
    }
}
