package com.example.practiceapi.service


import com.example.practiceapi.model.categories.ResponseCategory
import com.example.practiceapi.model.products.Product
import com.example.practiceapi.model.products.ResponseProduct
import retrofit2.Response

import retrofit2.http.GET

import retrofit2.http.Path

interface Product {

    @GET("products")
    suspend fun allProduct() : Response<ResponseProduct>

    @GET("products/{id}")
    suspend fun product(@Path("id") id:Int) : Response<Product>

    @GET("products/categories")
    suspend fun allCategory() : Response<ResponseCategory>



}