package com.example.stateparks

import android.content.Context
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.stateparks.data.Dummy
import com.example.stateparks.data.Park
import com.example.stateparks.data.ParksDatabase
import com.example.stateparks.utilities.PARKS_DATA_FILENAME
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkFirstRun()

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.navView)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment, R.id.parksFragment, R.id.activitiesFragment,
            R.id.reserveFragment, R.id.mapFragment, R.id.reserveFragment,
        ), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun checkFirstRun() {
        val sharedPrefs = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val firstRun = sharedPrefs.getBoolean("first_run", true)

        if (firstRun) {
            lifecycleScope.launch{
                forceDatabaseInit()
            }
            sharedPrefs.edit().putBoolean("first_run", false).apply()
        }
    }

    fun forceDatabaseInit() {
        val db = ParksDatabase.getInstance(this)

        val dummy = Dummy(1, "tom")
        lifecycleScope.launch{
            db.dummyDatabasaeDao.insert(dummy)
        }

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}