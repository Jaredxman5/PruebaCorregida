package practica

class PostCategory {

    static belongsTo=[post:Post,category:Category]
    
    static constraints = {
    }
}
