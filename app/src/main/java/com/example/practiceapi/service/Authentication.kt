package com.example.practiceapi.service

import com.example.practiceapi.model.login.RequestLogin
import com.example.practiceapi.model.login.ResponseLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Authentication {

    @POST("auth/login")
    suspend fun login(@Body request : RequestLogin) : Response<ResponseLogin>


}