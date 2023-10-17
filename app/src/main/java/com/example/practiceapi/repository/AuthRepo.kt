package com.example.practiceapi.repository

import com.example.practiceapi.model.login.RequestLogin
import com.example.practiceapi.model.login.ResponseLogin
import com.example.practiceapi.service.Authentication
import retrofit2.Response
import javax.inject.Inject

class AuthRepo @Inject constructor(private val auth: Authentication) {

    suspend fun login (request : RequestLogin) : Response<ResponseLogin>{
        return auth.login(request)

    }

}