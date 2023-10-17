package com.example.practiceapi.di

import com.example.practiceapi.service.Authentication
import com.example.practiceapi.service.Product

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Network {

    @Provides
    @Singleton
    fun retrofit (): Retrofit.Builder{
        return (
            Retrofit.Builder().baseUrl("https://dummyjson.com/").addConverterFactory(GsonConverterFactory.create())
        )

    }

    @Provides
    @Singleton
    fun auth (retrofit: Retrofit.Builder):Authentication{
        return retrofit.build().create(Authentication::class.java)
    }

    @Provides
    @Singleton
    fun allProduct (retrofit: Retrofit.Builder):Product{
        return retrofit.build().create(Product::class.java)
    }



}