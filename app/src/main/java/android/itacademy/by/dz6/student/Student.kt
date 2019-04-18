package android.itacademy.by.dz6.student

class Student {
    var firstName: String? = null
    var lastName: String? = null
    var textUrl: String? = null
        private set
    var id: Int = 0

    constructor(firstName: String, lastName: String, textUrl: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.textUrl = textUrl
    }

    constructor(id: Int, firstName: String, lastName: String, textUrl: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.textUrl = textUrl
        this.id = id
    }
}