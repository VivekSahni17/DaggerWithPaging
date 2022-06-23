package com.vivek.daggerwithpaging

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("products")
    suspend fun getProductList(@Query("page") page: Int): ProductList
}