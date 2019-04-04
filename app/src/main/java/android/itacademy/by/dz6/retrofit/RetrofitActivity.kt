package android.itacademy.by.dz6.retrofit

import android.app.Activity
import android.os.Bundle
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetrofitActivity : Activity() {

    private lateinit var retrofit :Retrofit
    private lateinit var studentApi: StudentApi


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retrofit = Retrofit.Builder()
                .baseUrl("https://api.backendless.com/BD6A1856-C855-3C8F-FF6D-CB79DCD38700/32C6E496-FCD4-35DF-FF39-49B49639E500/data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        studentApi = retrofit.create(StudentApi::class.java)

    }

    fun getApi() : StudentApi{
        return studentApi
    }
}

