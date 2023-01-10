package com.example.androidarchitechture2.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName ="contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name : String,
    val phone : String,
    val date : Date,
    val isActive : Int
    )
