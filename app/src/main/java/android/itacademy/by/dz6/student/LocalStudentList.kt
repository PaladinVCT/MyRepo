package android.itacademy.by.dz6.student

internal class LocalStudentList() {
    var list: ArrayList<Student>? = null

    companion object {
        val instance = LocalStudentList()
    }
}