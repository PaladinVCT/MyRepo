package android.itacademy.by.dz6.student

class Catalogue(){
lateinit var studentsList: List<Student>

    fun getStudent(id: Int):Student {
       return studentsList.get(id)
    }
}


