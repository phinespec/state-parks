package com.example.stateparks.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.stateparks.data.Activity
import com.example.stateparks.data.Park
import com.example.stateparks.data.ParksDatabase
import com.example.stateparks.utilities.JsonAssetReader
import com.example.stateparks.utilities.PARKS_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope
import timber.log.Timber

class SeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {

        val database = ParksDatabase.getInstance(applicationContext)

        try
        {
            val stateParks = JsonAssetReader.readList(
                "parks.json", applicationContext, Array<Park>::class.java
            )
            database.parksDatabaseDao.insertAll(stateParks)
            Result.success()
        } catch (ex: Exception)
        {
            Timber.e("Error seeding parks in state parks database")
            Result.failure()
        }

        try
        {
            val activities = JsonAssetReader.readList(
                "activities.json", applicationContext, Array<Activity>::class.java
            )
            database.activitiesDatabaseDao.insertAll(activities)
            Result.success()
        } catch (ex: Exception)
        {
            Timber.e("Error seeding activities in state parks database")
            Result.failure()
        }
//
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
    }


}