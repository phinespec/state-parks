package com.example.stateparks.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ActivitiesDatabaseDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(activities: List<Activity>)

    @Query("SELECT * FROM activities_table WHERE activityId = :key")
    fun get(key: Long): Activity?

    @Query("SELECT * FROM activities_table")
    fun getAllActivities(): LiveData<List<Activity>>
}