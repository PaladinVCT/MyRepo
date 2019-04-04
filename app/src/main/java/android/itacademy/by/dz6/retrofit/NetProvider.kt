package android.itacademy.by.dz6.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal fun provideApi(): StudentApi {

    val retrofit = Retrofit.Builder()
            .baseUrl("https://api.backendless.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    return retrofit.create(StudentApi::class.java)
}