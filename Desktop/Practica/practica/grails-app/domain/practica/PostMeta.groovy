package practica

class PostMeta {

    String llave
    String content
    
    static belongsTo=[post:Post]
    
    static constraints = {
        llave(nullable:false)
        content(blank:true,nullable:true)
    }
}
