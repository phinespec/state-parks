package com.example.stateparks.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "state_parks_table")
data class Park (
    @PrimaryKey(autoGenerate = true)
    val parkId: Long,

    @ColumnInfo(name = "parkName")
    val parkName: String,

    @ColumnInfo(name = "description")
    val remarks: String,

    @ColumnInfo(name = "latitude")
    val latitude: Double,

    @ColumnInfo(name = "longitude")
    val longitude: Double
    ):Parcelable


/**
 * SAMPLE OF JSON
 */
//"parkName": "Anasazi State Park Museum",
//"county": "Garfield",
//"size": "6 acres",
//"elevation": "6,700 ft",
//"yearEstablished": 1970,
//"yearlyVisitors": "20,824",
//"remarks": "Interprets a large Ancestral Puebloan village occupied from AD 1160 to 1235.",
//"favorite": true,
//"latitude": 37.9108,
//"longitude": 111.4236