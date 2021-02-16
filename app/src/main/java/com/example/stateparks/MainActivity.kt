package com.example.stateparks

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Listen for clicks on menu items
        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.parks -> Toast.makeText(this, "Parks was clicked",
                        Toast.LENGTH_LONG).show()
                R.id.activities -> Toast.makeText(this, "Activities was clicked",
                        Toast.LENGTH_LONG).show()
                R.id.resources -> Toast.makeText(this, "Resources was clicked",
                        Toast.LENGTH_LONG).show()
                R.id.map -> Toast.makeText(this, "Map was clicked",
                        Toast.LENGTH_LONG).show()
                R.id.reserve -> Toast.makeText(this, "Reserve was clicked",
                        Toast.LENGTH_LONG).show()
            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}