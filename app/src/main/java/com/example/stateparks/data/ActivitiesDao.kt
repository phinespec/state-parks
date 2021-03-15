package com.example.stateparks.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ActivitiesDao  {

    @Query("SELECT * FROM activities_table WHERE activityId = :key")
    fun get(key: Long): Activity?

    @Query("SELECT * FROM activities_table")
    fun getAllActivities(): LiveData<List<Activity>>
}