package com.example.stateparks.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activities_table")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    var activityId: Long,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name= "description")
    var description: String,
)
