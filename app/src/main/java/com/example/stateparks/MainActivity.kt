package com.example.stateparks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
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
                R.id.home -> Toast.makeText(applicationContext, "Home was clicked",
                Toast.LENGTH_SHORT).show()
                R.id.parks -> Toast.makeText(applicationContext, "Parks was clicked",
                        Toast.LENGTH_SHORT).show()
                R.id.activities -> Toast.makeText(applicationContext, "Activities was clicked",
                        Toast.LENGTH_SHORT).show()
                R.id.resources -> Toast.makeText(applicationContext, "Resources was clicked",
                        Toast.LENGTH_SHORT).show()
                R.id.map -> Toast.makeText(applicationContext, "Map was clicked",
                        Toast.LENGTH_SHORT).show()
                R.id.reserve -> Toast.makeText(applicationContext, "Reserve was clicked",
                        Toast.LENGTH_SHORT).show()
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