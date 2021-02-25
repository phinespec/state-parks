package com.example.stateparks.data

import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.stateparks.utilities.DATABASE_NAME
import com.example.stateparks.workers.SeedDatabaseWorker

@Database(entities = [Park::class, Dummy::class], version = 1, exportSchema = false)
abstract class ParksDatabase : RoomDatabase() {

    abstract val parksDatabaseDao: ParksDatabaseDao
    abstract val dummyDatabasaeDao: DummyDatabaseDao

    companion object {
        @Volatile private var instance: ParksDatabase? = null

        fun getInstance(context: Context): ParksDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): ParksDatabase {
            return Room.databaseBuilder(context, ParksDatabase::class.java, DATABASE_NAME)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                            WorkManager.getInstance(context).enqueue(request)
                        }
                    }
                )
                .build()
        }


    }

}