package com.example.androidarchitechture2.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitechture2.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class ShowQuoteAdapter(val context: Context, private val page : Int) : RecyclerView.Adapter<ShowQuoteAdapter.ViewHolder>() {
    val res: QuotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.retrofitquote, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        MainScope().launch {
            val fuck = res.getQuotes(page).body()
            fuck?.results?.apply{
                holder.context.text = this[position].content
                holder.author.text = this[position].author
            }?.toString()
        }
    }

    override fun getItemCount(): Int {
        return 20
    }
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val context : TextView = view.findViewById(R.id.content)
        val author : TextView = view.findViewById(R.id.author)
    }
}