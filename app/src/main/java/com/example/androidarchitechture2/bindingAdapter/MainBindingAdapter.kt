package com.example.androidarchitechture2.bindingAdapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.databinding.ActivityMainBinding
import com.example.androidarchitechture2.databinding.ActivityMainBindingAdapterBinding

class MainBindingAdapter : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBindingAdapterBinding
    //lateinit var postAdapter: PostAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_binding_adapter)
        supportActionBar?.hide()

        val post = PostAdapter("Gaddar", "This is a software engineer", "https://secure.gravatar.com/avatar/e89584fc717a92922689cb33ab29dd93?s=160&d=https%3A%2F%2Fcss-tricks.com%2Fimages%2Fget-gravatar.png&r=PG")
        mainBinding.post = post
    }
}