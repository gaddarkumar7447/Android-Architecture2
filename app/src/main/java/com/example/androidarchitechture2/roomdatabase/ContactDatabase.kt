package com.example.androidarchitechture2.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converter::class)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDAO
}