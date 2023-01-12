package com.example.androidarchitechture2.mvvm_retrofit.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesServices {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page : Int) : Response<Quotes>
}