package com.example.stateparks.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ParksDatabaseDao {

    @Dao
    interface ParksDatabaseDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertAll(parks: List<Park>)

        @Query("SELECT * FROM state_parks_table WHERE id = :key")
        suspend fun get(key: Long): Park?

        @Query("SELECT * FROM state_parks_table ORDER BY id DESC")
        fun getAllParks(): LiveData<List<Park>>
    }


}