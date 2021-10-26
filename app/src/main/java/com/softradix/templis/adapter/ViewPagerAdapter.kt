package com.softradix.templis.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.softradix.templis.ui.fragments.home.HomeFragment
import com.softradix.templis.ui.fragments.movies.MoviesFragment
import com.softradix.templis.ui.fragments.sports.SportsFragment
import com.softradix.templis.ui.fragments.tv.TvFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int) = when (position) {
        0 -> HomeFragment()
        1 -> HomeFragment()
        2 -> HomeFragment()
        3 -> HomeFragment()
        /*
        1 -> TvFragment()
        2 -> MoviesFragment()
        3 -> SportsFragment()*/
        else -> HomeFragment()
    }
}