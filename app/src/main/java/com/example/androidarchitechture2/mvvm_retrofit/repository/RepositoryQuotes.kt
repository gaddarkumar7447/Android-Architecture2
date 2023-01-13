package com.example.androidarchitechture2.mvvm_retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidarchitechture2.mvvm_retrofit.api.Quotes
import com.example.androidarchitechture2.mvvm_retrofit.api.QuotesServices
//import com.example.androidarchitechture2.mvvm_retrofit.db.MvvmDatabase


class RepositoryQuotes(private val quotesServices: QuotesServices, /*private val mvvmDatabase: MvvmDatabase*/) {
    private val mutableLiveData = MutableLiveData<Quotes> ()

    val quotes : LiveData<Quotes>
    get() = mutableLiveData

    suspend fun getQuotes(page: Int) {

        val result = quotesServices.getQuotes(page)

        if (result.body() != null){
//            mvvmDatabase.quoDao().addQuotes(result.body()!!.results)
            mutableLiveData.postValue(result.body())
        }

    }
}