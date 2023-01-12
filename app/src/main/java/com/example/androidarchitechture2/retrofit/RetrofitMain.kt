package com.example.androidarchitechture2.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.databinding.ActivityRetrofitMainBinding

class RetrofitMain : AppCompatActivity() {
    lateinit var dataBinding : ActivityRetrofitMainBinding
    lateinit var quotesApi: QuotesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit_main)
        supportActionBar?.hide()
        /*val retrofitInstance = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        MainScope().launch {
            val result = retrofitInstance.getQuotes(1)
            if (result != null){
                Log.d("quote", result.body().toString())
                val quote = result.body()
                if (quote != null) {
                    quote.results.forEach{
                        Log.d("q",it.content)
                    }
                }
            }
        }*/

        var page = 1
        if (page==1){
            val adapter = ShowQuoteAdapter(this, page)
            dataBinding.recyclerView1.layoutManager = LinearLayoutManager(this)
            dataBinding.recyclerView1.hasFixedSize()
            dataBinding.recyclerView1.adapter = adapter
        }

        dataBinding.submit.setOnClickListener(View.OnClickListener {
            page = dataBinding.page.text.toString().toInt()
            if (page in 1 ..130){
                val adapter = ShowQuoteAdapter(this, page)
                dataBinding.recyclerView1.layoutManager = LinearLayoutManager(this)
                dataBinding.recyclerView1.hasFixedSize()
                dataBinding.recyclerView1.adapter = adapter
            }
        })

    }

}