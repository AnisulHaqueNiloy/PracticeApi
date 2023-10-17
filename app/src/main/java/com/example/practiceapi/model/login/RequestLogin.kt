package com.example.practiceapi.model.login


import com.google.gson.annotations.SerializedName

data class RequestLogin(
    @SerializedName("username")
    var username: String?,
    @SerializedName("password")
    var password: String?
)