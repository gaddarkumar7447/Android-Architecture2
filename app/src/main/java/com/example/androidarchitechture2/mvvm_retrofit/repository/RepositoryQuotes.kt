package com.example.androidarchitechture2.mvvm_retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidarchitechture2.mvvm_retrofit.api.Quotes
import com.example.androidarchitechture2.mvvm_retrofit.api.QuotesServices


class RepositoryQuotes(private val quotesServices: QuotesServices) {

    private val mutableLiveData = MutableLiveData<Quotes> ()

    val quotes : LiveData<Quotes>
    get() = mutableLiveData

    suspend fun getQuotes(page: Int) {

        val result = quotesServices.getQuotes(page)

        if (result.body() != null){
            mutableLiveData.postValue(result.body())
        }

    }
}