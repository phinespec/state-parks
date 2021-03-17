package com.example.stateparks.view.activities

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stateparks.data.ActivitiesDatabaseDao
import com.example.stateparks.data.Park

class ActivitiesViewModel(
    val database: ActivitiesDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    val activities = database.getAllActivities()

}