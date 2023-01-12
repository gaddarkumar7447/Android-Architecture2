package com.example.androidarchitechture2.mvvm_retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitechture2.mvvm_retrofit.repository.RepositoryQuotes

class ViewModelFactoryClass(val page : Int, private val repositoryQuotes: RepositoryQuotes) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewModelClass(page, repositoryQuotes) as T
    }

}