package com.example.androidarchitechture2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var mutableLiveData = MutableLiveData("I hope I get job soon")

    fun getChange(){
        mutableLiveData.value = "Yes we achieve your target very soon"
    }

}