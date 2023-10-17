package com.example.practiceapi.model.login


import com.google.gson.annotations.SerializedName

data class ResponseLogin(
    @SerializedName("token")
    var token: String?
)