package com.example.photographer.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.photographer.R
import com.example.photographer.databinding.MainActivityBinding
import com.example.photographer.ui.fragment.FavsFragment
import com.example.photographer.ui.fragment.HomeFragment
import com.example.photographer.ui.fragment.NewsFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        loadFragment(HomeFragment())
        bottomNavConfig()

        setContentView(binding.root)
    }

    private fun loadFragment(fragment: Fragment) {
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_content, fragment)
        ft.commit()
    }

    private fun bottomNavConfig() {
        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_scan -> loadFragment(HomeFragment())
                R.id.item_festivals -> loadFragment(NavHostFragment.create(R.navigation.nav_graph))
                R.id.item_news -> loadFragment(NewsFragment())
                R.id.item_favs -> loadFragment(FavsFragment())
            }
            true
        }
    }
}