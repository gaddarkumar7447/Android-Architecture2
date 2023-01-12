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

        val post = PostAdapter("Gaddar", "This is a software engineer", "https://instagram.fixb2-1.fna.fbcdn.net/v/t51.2885-19/322327737_179498298006458_4585926227345056937_n.jpg?stp=dst-jpg_s320x320&_nc_ht=instagram.fixb2-1.fna.fbcdn.net&_nc_cat=102&_nc_ohc=iNqs2bTMxpEAX-Nbn1J&edm=AOQ1c0wBAAAA&ccb=7-5&oh=00_AfB3tqevpiNzJqdQwvKMPa5bsDvMdQbmFj3QRT-mweWnSQ&oe=63C5615D&_nc_sid=8fd12b")
        mainBinding.post = post
    }
}