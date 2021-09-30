package com.example.beducompras.api

import org.bedu.shopping.data.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface FakeStoreService {
    @GET("products")
    fun getProducts(): Call<List<Product>>
}