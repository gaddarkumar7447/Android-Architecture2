package com.example.androidarchitechture2.roomdatabase

import android.app.PictureInPictureParams
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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

        val migration = Migration(1,2){
            supportSQLiteDatabase: SupportSQLiteDatabase ->
            supportSQLiteDatabase.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
        }

        database = Room.databaseBuilder(applicationContext,ContactDatabase::class.java,"contactDB").addMigrations(migration).build()


        val contact = Contact(0,"Gaddar","7564078124", Date(),1)

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