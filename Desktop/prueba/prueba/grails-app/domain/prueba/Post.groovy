package prueba

class Post {
    int id
    int authorId
    int parentId
    String title
    String metaTitle
    String slug
    String summary
    int published
    Date createdAt
    Date updatedAt
    Date publishedAt
    String content
    
    static constraints = {
    }
}
