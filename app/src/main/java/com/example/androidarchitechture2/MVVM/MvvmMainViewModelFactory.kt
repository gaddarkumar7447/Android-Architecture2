package com.example.androidarchitechture2.MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MvvmMainViewModelFactory(private val quoteRepository: QuoteRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MvvmViewModel(quoteRepository) as T
    }
}