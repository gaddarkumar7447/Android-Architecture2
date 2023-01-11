package com.example.androidarchitechture2.diffutil

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitechture2.R

class ProgrammingAdapter : ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingViewHolder>(DiffUtilComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ProgrammingViewHolder(view : View) : RecyclerView.ViewHolder(view){
        private val initial : TextView = view.findViewById(R.id.initial)
        val name : TextView = view.findViewById(R.id.name)

        fun bind(item : ProgrammingItem){
            name.text = item.name
            initial.text = item.initial
        }
    }

    class DiffUtilComparator() : DiffUtil.ItemCallback<ProgrammingItem>(){
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem == newItem
        }

    }

}