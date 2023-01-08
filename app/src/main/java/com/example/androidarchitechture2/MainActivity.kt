package com.example.androidarchitechture2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.androidarchitechture2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()
        val q = Quotes("Dam hai to rok ke deekha", "veer")
        dataBinding.quotesUI = q
    }
}