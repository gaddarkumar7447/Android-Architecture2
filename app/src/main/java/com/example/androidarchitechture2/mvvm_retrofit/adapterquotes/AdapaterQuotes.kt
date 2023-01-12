package com.example.androidarchitechture2.mvvm_retrofit.adapterquotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.mvvm_retrofit.viewmodel.ViewModelClass

class AdapaterQuotes(private val viewModelClass: ViewModelClass, val context: Context) : RecyclerView.Adapter<AdapaterQuotes.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.mvvmretrofitquotes, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        viewModelClass.quoteList.observeForever(Observer {
            holder.author.text = it.results[position].author
            holder.content.text = it.results[position].content
        })
    }

    override fun getItemCount(): Int {
        return 20
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val content : TextView = view.findViewById(R.id.contentQuotes)
        val author : TextView = view.findViewById(R.id.authorQuotes)

    }
}