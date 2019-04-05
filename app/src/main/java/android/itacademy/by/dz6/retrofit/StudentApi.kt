package android.itacademy.by.dz6.retrofit

import android.itacademy.by.dz6.student.Student
import io.reactivex.Observable
import retrofit2.http.*

interface StudentApi {

    @GET("BD6A1856-C855-3C8F-FF6D-CB79DCD38700/32C6E496-FCD4-35DF-FF39-49B49639E500/data/StudentsTable")
    fun getStudents(): Observable<ArrayList<Student>>

    @POST("BD6A1856-C855-3C8F-FF6D-CB79DCD38700/32C6E496-FCD4-35DF-FF39-49B49639E500/data/StudentsTable")
    fun createStudent(student: Student)

    @DELETE("BD6A1856-C855-3C8F-FF6D-CB79DCD38700/32C6E496-FCD4-35DF-FF39-49B49639E500/data/StudentsTable")
    fun deleteStudent(objectId: String)

    @PUT("BD6A1856-C855-3C8F-FF6D-CB79DCD38700/32C6E496-FCD4-35DF-FF39-49B49639E500/data/StudentsTable")
    fun editStudent(@Body student: Student)
}