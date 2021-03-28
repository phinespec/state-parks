package com.example.stateparks

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.util.JsonReader
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
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
import com.example.stateparks.view.activities.ActivitiesFragment
import com.example.stateparks.view.home.HomeFragment
import com.example.stateparks.view.parks.ParksFragment
import com.example.stateparks.view.reserve.ReserveFragment
import com.example.stateparks.view.resources.ResourcesFragment
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkFirstRun()

        val home = HomeFragment()
        val parks = ParksFragment()
        val activities = ActivitiesFragment()
        val resources = ResourcesFragment()
        val reserve = ReserveFragment()

        makeCurrentFragment(home)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> makeCurrentFragment(home)
                R.id.parksFragment -> makeCurrentFragment(parks)
                R.id.activitiesFragment -> makeCurrentFragment(activities)
                R.id.reserveFragment -> makeCurrentFragment(reserve)
                R.id.resourcesFragment -> makeCurrentFragment(resources)
            }
            true
        }

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

    fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
            commit()
        }

    fun forceDatabaseInit() {
        val db = ParksDatabase.getInstance(this)

        val dummy = Dummy(1, "tom")
        lifecycleScope.launch{
            db.dummyDatabaseDao.insert(dummy)
        }

    }


}