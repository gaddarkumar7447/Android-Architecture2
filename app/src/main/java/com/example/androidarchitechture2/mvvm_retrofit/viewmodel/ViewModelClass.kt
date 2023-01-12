package com.example.androidarchitechture2.mvvm_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitechture2.mvvm_retrofit.api.Quotes
import com.example.androidarchitechture2.mvvm_retrofit.repository.RepositoryQuotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelClass(val page: Int, private val repositoryQuotes: RepositoryQuotes) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryQuotes.getQuotes(page)
        }
    }

    val quoteList : LiveData<Quotes>
    get() = repositoryQuotes.quotes

}