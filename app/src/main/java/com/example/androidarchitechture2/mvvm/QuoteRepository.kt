package com.example.androidarchitechture2.mvvm

import androidx.lifecycle.LiveData

class QuoteRepository(private val quote : QuoteDao) {
    fun getQuote(): LiveData<List<Quote>> {
        return quote.getQuote()
    }

    suspend fun insertQuotes(quote: Quote){
        this.quote.insertQuote(quote)
    }
}