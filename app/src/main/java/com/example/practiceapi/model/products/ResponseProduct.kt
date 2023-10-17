package com.example.practiceapi.model.products


import com.google.gson.annotations.SerializedName

data class ResponseProduct(
    @SerializedName("products")
    var products: List<Product?>?,
    @SerializedName("total")
    var total: Int?,
    @SerializedName("skip")
    var skip: Int?,
    @SerializedName("limit")
    var limit: Int?
)