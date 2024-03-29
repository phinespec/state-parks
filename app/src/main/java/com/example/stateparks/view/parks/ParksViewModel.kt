package com.example.stateparks.view.parks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stateparks.data.Park
import com.example.stateparks.data.ParksDatabaseDao

class ParksViewModel(
    val database: ParksDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    val parks = database.getAllParks()

    private val _navigateToMap = MutableLiveData<Park>()
    val navigateToMap: LiveData<Park>
    get() = _navigateToMap


    private suspend fun getParkFromDatabase(id: Long): Park? {
        return database.get(id)

    }
}