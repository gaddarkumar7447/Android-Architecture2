package com.example.androidarchitechture2.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MvvmViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() : LiveData<List<Quote>>{
        return quoteRepository.getQuote()
    }

    fun insertQuote(quote: Quote){
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuotes(quote)
        }
    }

}