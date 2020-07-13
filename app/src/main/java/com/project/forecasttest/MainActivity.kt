package com.project.forecasttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.forecasttest.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        content_layout.adapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.currentWeatherFragment -> {
                    content_layout.setCurrentItem(0,false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.futureListWeatherFragment -> {
                    content_layout.setCurrentItem(1,false)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }
}
