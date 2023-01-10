package com.example.androidarchitechture2.roomdatabase

import androidx.room.TypeConverter
import java.util.*


class Converter {
    @TypeConverter
    fun getDate(value : Long) : Date {
        return Date(value)
    }

    @TypeConverter
    fun storeDate(value : Date) : Long{
        return value.time
    }
}