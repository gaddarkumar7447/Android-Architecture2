package com.example.androidarchitechture2.MVVM

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("SELECT * FROM quote")
    fun getQuote () : LiveData<List<Quote>>

    @Insert
    suspend fun insertQuote(quote: Quote)
}