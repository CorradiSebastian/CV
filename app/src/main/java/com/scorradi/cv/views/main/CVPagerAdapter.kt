package com.scorradi.cv.views.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CVPagerAdapter(fragmentManager: FragmentManager, private val fragments: List<Fragment>) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    // 2
    override fun getItem(position: Int): Fragment {
        return fragments[position]

    }

    // 3
    override fun getCount(): Int {
        return fragments.size
    }
}