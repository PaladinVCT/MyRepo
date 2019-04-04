package android.itacademy.by.dz6.student

data class Student(

        val PHOTO_URL: String,
        val ID: Int,
        val LAST_NAME: String,
        val objectId: String,
        val NAME: String
){

    fun getName() :String{
        return NAME
    }
}