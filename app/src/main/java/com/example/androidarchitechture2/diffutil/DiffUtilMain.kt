package com.example.androidarchitechture2.diffutil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.databinding.ActivityDiffUtilMainBinding

class DiffUtilMain : AppCompatActivity() {
    lateinit var dataBinding: ActivityDiffUtilMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_diff_util_main)
        val adapter = ProgrammingAdapter()



        val arrlist = ArrayList<ProgrammingItem>(5)

        arrlist.add(ProgrammingItem(1,"G","Gaddar"))
        arrlist.add(ProgrammingItem(2,"S","Sumit"))
        arrlist.add(ProgrammingItem(3,"R","Ravi"))
        arrlist.add(ProgrammingItem(4,"S","Saheb"))
        arrlist.add(ProgrammingItem(5,"G","Gaddar"))
        arrlist.add(ProgrammingItem(6,"S","Sumit"))
        arrlist.add(ProgrammingItem(7,"R","Ravi"))
        arrlist.add(ProgrammingItem(8,"S","Saheb"))
        arrlist.add(ProgrammingItem(9,"G","Gaddar"))
        arrlist.add(ProgrammingItem(10,"S","Sumit"))
        arrlist.add(ProgrammingItem(11,"R","Ravi"))
        arrlist.add(ProgrammingItem(12,"S","Saheb"))


        adapter.submitList(arrlist)


        dataBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        dataBinding.recyclerView.hasFixedSize()
        dataBinding.recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val list = ProgrammingItem(13, "G", "Kumar")
            val list1 = ProgrammingItem(14, "R", "Yadav")
            val list2 = ProgrammingItem(15, "R", "Chaudhary")
            val list3 = ProgrammingItem(15, "S", "Mishra")
            val list4 = ProgrammingItem(12,"G","Gaddar")
            val list5 = ProgrammingItem(10,"S","Sumit")

            adapter.submitList(listOf(list,list1,list2,list3,list4,list5))
        },2000)


    }
}