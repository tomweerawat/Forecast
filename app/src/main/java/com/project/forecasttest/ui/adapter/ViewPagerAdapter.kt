package com.project.forecasttest.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.project.forecasttest.ui.HistoryFragment
import com.project.forecasttest.ui.MainFragment


class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {

    private val fragments = mutableListOf<Fragment>()

    override fun getItem(position: Int): Fragment {

        return if (fragments.indices.contains(position)) {
            fragments[position]
        } else {

            val frg = if (position == 0) {
                MainFragment()
            } else if (position ==1)  {
                HistoryFragment()
            }else{
                MainFragment()
            }

            fragments.add(position, frg)

            frg
        }
    }

    override fun getCount() = 2
}