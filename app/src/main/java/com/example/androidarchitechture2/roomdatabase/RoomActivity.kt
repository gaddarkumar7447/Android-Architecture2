package com.example.androidarchitechture2.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import com.example.androidarchitechture2.R
import com.example.androidarchitechture2.databinding.ActivityRoomBinding
import kotlinx.coroutines.*
import java.util.*

class RoomActivity : AppCompatActivity() {
    private lateinit var roomDataBinding : ActivityRoomBinding
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roomDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_room)
        supportActionBar?.hide()

        database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").build()

        val contact = Contact(0,"Gaddar","7564078124", Date())

        MainScope().launch {
            database.contactDao().insertContact(contact)
        }
    }

    fun updateData(view: View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.d("TAG", it.toString())
        })
    }
}