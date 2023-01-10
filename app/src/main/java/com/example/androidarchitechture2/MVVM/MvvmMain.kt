package com.example.androidarchitechture2.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.databinding.ActivityMvvmMainBinding

class MvvmMain : AppCompatActivity() {
    lateinit var dataMvvmMain: ActivityMvvmMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataMvvmMain = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_main)
        supportActionBar?.hide()


    }
}