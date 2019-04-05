package android.itacademy.by.dz6.student

internal class LocalStudentList() {
    var list: List<Student>? = null

    companion object {
        val instance = LocalStudentList()
    }
}