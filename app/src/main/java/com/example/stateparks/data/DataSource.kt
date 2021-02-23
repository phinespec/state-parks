package com.example.stateparks.data

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stateparks.R

class DataSource(resources: Resources) {

    private val initialParksList = parksList(resources)
    private val parksLiveData = MutableLiveData(initialParksList)

    fun getParkForId(id: Long): Park? {
        parksLiveData.value?.let { parks ->
            return parks.firstOrNull{ it.id == id }
        }

        return null
    }


    fun getParksList(): LiveData<List<Park>> {
        return parksLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}