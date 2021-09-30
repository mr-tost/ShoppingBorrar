package com.example.beducompras.api

import org.bedu.shopping.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface LoginService {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String): Response<LoginResponse>
}