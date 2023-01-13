package com.example.androidarchitechture2.mvvm_retrofit

import android.app.Application
import androidx.room.Room
import com.example.androidarchitechture2.mvvm_retrofit.repository.RepositoryQuotes
import com.example.androidarchitechture2.mvvm_retrofit.api.QuotesServices
import com.example.androidarchitechture2.mvvm_retrofit.api.RetrofitHelper
// import com.example.androidarchitechture2.mvvm_retrofit.db.MvvmDatabase

/*
class QuoteApplication : Application() {
    lateinit var quotesRepository: RepositoryQuotes
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quotesServices = RetrofitHelper.getInstance().create(QuotesServices::class.java)
        val database = MvvmDatabase.getDataBase(applicationContext)
        quotesRepository = RepositoryQuotes(quotesServices, database)
    }
}*/
