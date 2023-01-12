package com.example.androidarchitechture2.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.databinding.ActivityMvvmRetrofitMainBinding
import com.example.androidarchitechture2.mvvm_retrofit.adapterquotes.AdapaterQuotes
import com.example.androidarchitechture2.mvvm_retrofit.api.QuotesServices
import com.example.androidarchitechture2.mvvm_retrofit.api.RetrofitHelper
import com.example.androidarchitechture2.mvvm_retrofit.repository.RepositoryQuotes
import com.example.androidarchitechture2.mvvm_retrofit.viewmodel.ViewModelClass
import com.example.androidarchitechture2.mvvm_retrofit.viewmodel.ViewModelFactoryClass

class MvvmRetrofitMain : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMvvmRetrofitMainBinding
    lateinit var viewModelClass: ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_retrofit_main)
        supportActionBar?.hide()

        var page = 1

        val quotesServices = RetrofitHelper.getInstance().create(QuotesServices::class.java)
        val repository = RepositoryQuotes(quotesServices)


        /*val view = viewModelClass.quoteList.observe(this, Observer {
            Log.d("tag", it.results.toString())
        })*/

        /*if (page in 1..130) {
            viewModelClass = ViewModelProvider(this, ViewModelFactoryClass(page, repository))[ViewModelClass::class.java]
            val adapter = AdapaterQuotes(viewModelClass, this)
            dataBinding.recyclerViewQuotes.layoutManager = LinearLayoutManager(this)
            dataBinding.recyclerViewQuotes.hasFixedSize()
            dataBinding.recyclerViewQuotes.adapter = adapter
        } else {
            Log.d("withoutB", page.toString())
            Toast.makeText(this, "Enter page number between 1 to 130", Toast.LENGTH_SHORT).show()
        }*/

        dataBinding.submitButton.setOnClickListener(View.OnClickListener {
            page = dataBinding.pageEnter.text.toString().toInt()
            if (page in 1..130) {
                viewModelClass = ViewModelProvider(this, ViewModelFactoryClass(page, repository))[ViewModelClass::class.java]
                Log.d("click",page.toString())
                val adapter = AdapaterQuotes(viewModelClass, this)
                dataBinding.recyclerViewQuotes.layoutManager = LinearLayoutManager(this)
                dataBinding.recyclerViewQuotes.hasFixedSize()
                dataBinding.recyclerViewQuotes.adapter = adapter
            } else {
                Log.d("withB", page.toString())
                Toast.makeText(this, "Enter page number between 1 to 130", Toast.LENGTH_SHORT).show()
            }
        })


    }
}