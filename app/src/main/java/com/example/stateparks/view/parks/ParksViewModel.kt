package com.example.stateparks.view.parks

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.stateparks.data.ParksDatabaseDao

class ParksViewModel(
    val database: ParksDatabaseDao,
    application: Application
) : AndroidViewModel(application) {
}