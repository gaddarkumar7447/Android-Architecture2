package com.example.androidarchitechture2.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    val BASE_URL= "https://quotable.io/"

    fun getInstance() : Retrofit{
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

}

