package com.example.practiceapi.repository

import com.example.practiceapi.model.categories.ResponseCategory
import com.example.practiceapi.model.login.RequestLogin
import com.example.practiceapi.model.login.ResponseLogin
import com.example.practiceapi.model.products.ResponseProduct
import com.example.practiceapi.service.Authentication
import com.example.practiceapi.service.Product
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(private val service: Product) {

    suspend fun allProduct () : Response<ResponseProduct>{
        return service.allProduct()

    }

    suspend fun product(id:Int) : Response<com.example.practiceapi.model.products.Product>{
        return service.product(id)
    }

    suspend fun allCategory () : Response<ResponseCategory>{
        return service.allCategory()

    }

}