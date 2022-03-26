package practica

class Tag {

    String title
    String metaTitle
    String slug
    String content
    
    static constraints = {
        title(unique:true,nullable:false)
        metaTitle(blank:true,nullable:true)
        slug(blank:true,nullable:false)
        content(blank:true,nullable:true)
    }
}
