package com.example.stateparks.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface DummyDatabaseDao {

    @Insert
    suspend fun insert(dummy: Dummy)
}