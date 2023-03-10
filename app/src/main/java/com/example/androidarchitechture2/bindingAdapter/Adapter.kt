package com.example.androidarchitechture2.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFormUrl")
fun ImageView.getImage(url: String) {
    Glide.with(context).load(url).into(this)
}