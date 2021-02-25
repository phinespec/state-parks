package com.example.stateparks.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="dummy_data_table")
data class Dummy(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "dummy_name")
    val name: String
)




//@Entity(tableName = "state_parks_table")
//data class Park (
//    @PrimaryKey(autoGenerate = true)
//    val id: Long = 0L,
//
//    @ColumnInfo(name = "parkName")
//    val name: String,
//
//    @ColumnInfo(name = "description")
//    val remarks: String,
//
//    @ColumnInfo(name = "latitude")
//    val latitude: Double,
//
//    @ColumnInfo(name = "longitude")
//    val longitude: Double
//)
//)
