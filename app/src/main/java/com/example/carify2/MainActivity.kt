package com.example.carify2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show()

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)

        bottomBar.setOnItemSelectedListener { menuItem ->


            when (menuItem.itemId) {
                R.id.nav_Guard -> inflateFragment(GuardFragment.newInstance())
                R.id.nav_home -> {

                    inflateFragment(HomeFragment.newInstance())

                }

                R.id.nav_dashboard -> {

                    inflateFragment(DashboardFragment.newInstance())

                }

                R.id.nav_Profile -> {

                    inflateFragment(ProfileFragment.newInstance())

                }
            }


            true
        }
        bottomBar.selectedItemId = R.id.nav_home

    }

    private fun inflateFragment(newInstance: Fragment) {


        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()


    }


}


