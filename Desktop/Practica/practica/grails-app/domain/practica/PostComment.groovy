package practica

class PostComment {

    PostComment parent
    String title
    int published
    Date createdAt
    Date publishedAt
    String content
    
    static belongsTo=[post:Post]
    
    static constraints = {
        title(unique:true,nullable:false)
        published(nullable:false)
        publishedAt(nullable:true)
        content(blank:true,nullable:true)
    }
}
