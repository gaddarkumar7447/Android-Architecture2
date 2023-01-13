package com.example.androidarchitechture2.mvvm_retrofit.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidarchitechture2.mvvm_retrofit.api.Result
/*
@Database(entities = [Result::class], version = 1)
abstract class MvvmDatabase  : RoomDatabase(){

    abstract fun quoDao() : MvvmDAO

    companion object{
        var instance : MvvmDatabase?= null
        fun getDataBase(context : Context) : MvvmDatabase{
            if (instance == null){
                synchronized(this){
                    instance = Room.databaseBuilder(context, MvvmDatabase::class.java, "quotesbds").build()
                }
            }
            return instance!!
        }
    }

}*/
