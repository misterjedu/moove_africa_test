package com.oladokun.mooveafricatest.ui.shared

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class GenericViewPagerAdapter(
    fm: FragmentManager,
    lifeCycle: Lifecycle,
    list: MutableList<Fragment>
) : FragmentStateAdapter(fm, lifeCycle) {

    private val fragmentList: MutableList<Fragment> = list

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
