package prueba

class User {
    int id
    String firstName
    String middleName
    String lastName
    String mobile
    String email
    String passwordHash
    Date registeredAt
    Date lastLogin
    String intro
    String profile

    static constraints = {
        email(email:true)
    }
}
