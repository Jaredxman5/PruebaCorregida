package practica

class PostTag {

    static belongsTo=[post:Post,tag:Tag]
    
    static constraints = {
    }
}
