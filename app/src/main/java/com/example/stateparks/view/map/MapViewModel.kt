package com.example.stateparks.view.map

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stateparks.data.Park
import com.example.stateparks.data.ParksDatabaseDao

class MapViewModel(
    val database: ParksDatabaseDao,
    application: Application
) : AndroidViewModel(application) {


}