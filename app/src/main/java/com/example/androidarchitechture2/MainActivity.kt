package com.example.androidarchitechture2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitechture2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding : ActivityMainBinding
    private lateinit var mainLiveData: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()

        mainLiveData = ViewModelProvider(this)[MainViewModel::class.java]

        dataBinding.showQuotes = mainLiveData
        // Observer change in live data for this binding
        dataBinding.lifecycleOwner = this

    }
}