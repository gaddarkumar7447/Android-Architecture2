package com.example.androidarchitechture2.MVVM

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class QuoteDataBase : RoomDatabase(){

    abstract fun quoteDao() : QuoteDao

}