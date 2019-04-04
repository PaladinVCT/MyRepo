package android.itacademy.by.dz6.retrofit

import android.itacademy.by.dz6.student.Catalogue
import android.itacademy.by.dz6.student.Student
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST


interface StudentApi{

    @GET("StudentsTable")
    fun getStudents(): Single<Catalogue>

    @POST("StudentsTable")
    fun createStudent(student: Student)

    @DELETE("StudentsTable")
    fun deleteStudent(objectId: String)
}