package com.example.androidarchitechture2.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.databinding.ActivityMvvmMainBinding

class MvvmMain : AppCompatActivity() {
    lateinit var dataMvvmMain: ActivityMvvmMainBinding
    lateinit var mvvmViewModel: MvvmViewModel
    lateinit var quoteDao: QuoteDao
    lateinit var quoteDataBase: QuoteDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataMvvmMain = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_main)
        supportActionBar?.hide()

        quoteDataBase = Room.databaseBuilder(this, QuoteDataBase::class.java, "quote").createFromAsset("quotes.db").build()

        quoteDao = quoteDataBase.quoteDao()

        val quoteRepository = QuoteRepository(quoteDao)

        mvvmViewModel = ViewModelProvider(this, MvvmMainViewModelFactory(quoteRepository))[MvvmViewModel::class.java]


        mvvmViewModel.getQuotes().observe(this, Observer {
            dataMvvmMain.quotes = it.toString()
        })

        dataMvvmMain.btnAddQuote.setOnClickListener(View.OnClickListener {
            val quote = Quote(0, "Gaddar Kumar Chaudhary", "Gadar")
            mvvmViewModel.insertQuote(quote)
        })

    }
}
