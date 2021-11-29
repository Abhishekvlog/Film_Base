package com.example.flimbase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.flimbase.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val premiumFragment = PremiumFragment()
        val searchFragment = SearchFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)
        bottom_Navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_premium -> makeCurrentFragment(premiumFragment)
                R.id.ic_search -> makeCurrentFragment(searchFragment)
                R.id.ic_profile -> makeCurrentFragment(profileFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment : Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment,fragment).commit()
        }
}