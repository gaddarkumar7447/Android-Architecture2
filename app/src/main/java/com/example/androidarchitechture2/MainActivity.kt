package com.example.androidarchitechture2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitechture2.mvvm.MvvmMain
import com.example.androidarchitechture2.bindingAdapter.MainBindingAdapter
import com.example.androidarchitechture2.databinding.ActivityMainBinding
import com.example.androidarchitechture2.diffutil.DiffUtilMain
import com.example.androidarchitechture2.mvvm_retrofit.MvvmRetrofitMain
import com.example.androidarchitechture2.retrofit.RetrofitMain
import com.example.androidarchitechture2.roomdatabase.RoomActivity

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding : ActivityMainBinding
    private lateinit var mainLiveData: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()

        mainLiveData = ViewModelProvider(this)[MainViewModel::class.java]

        dataBinding.showQuotes = mainLiveData
        // Observer change in live data for this binding
        dataBinding.lifecycleOwner = this

        dataBinding.mvvmRetrofit.setOnClickListener(View.OnClickListener { startActivity(Intent(this, MvvmRetrofitMain::class.java)) })

    }

    fun bindingAdapter(view: View) { startActivity(Intent(this, MainBindingAdapter::class.java)) }
    fun mvvmActivity(view: View) { startActivity(Intent(this, MvvmMain::class.java))}
    fun roomActivity(view: View) {startActivity(Intent(this, RoomActivity::class.java))}
    fun diffUtil(view: View) {startActivity(Intent(this, DiffUtilMain::class.java))}
    fun retrofit(view: View) {startActivity(Intent(this, RetrofitMain::class.java))}
}