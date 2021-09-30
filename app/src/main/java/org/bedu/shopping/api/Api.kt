package org.bedu.shopping.api

import com.example.beducompras.api.FakeStoreService
import com.example.beducompras.api.LoginService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Api {
    private const val STORE_URL = "https://fakestoreapi.com/"
    private const val LOGIN_URL = "https://reqres.in/api/"


    private val httpClient = OkHttpClient.Builder()
        .addInterceptor( HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        //.connectTimeout(1, TimeUnit.MINUTES)
        //.readTimeout(30, TimeUnit.SECONDS)
        .build()

    val storeService: FakeStoreService by lazy{
        Retrofit.Builder()
            .baseUrl(STORE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(FakeStoreService::class.java)
    }

    val loginService: LoginService by lazy{
        Retrofit.Builder()
            .baseUrl(LOGIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginService::class.java)
    }
}