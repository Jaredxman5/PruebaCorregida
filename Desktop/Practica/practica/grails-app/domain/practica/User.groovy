package practica

class User {
    
    String firstName
    String middleName
    String lastName
    String mobile
    String email
    String passwordHash
    Date registeredAt=new Date()
    Date lastLogin= new Date()
    String intro
    String profile

    static constraints = {
        firstName(blank:true,nullable:true)
        middleName(blank:true,nullable:true)
        lastName(blank:true,nullable:true)
        mobile(blank:true,nullable:true,Number:true)
        email(unique:true,blank:true,nullable:true,email:true)
        passwordHash(blank:true,nullable:false)
        intro(blank:true,nullable:true)
        profile(unique:true,blank:true,nullable:true)
    }
}
