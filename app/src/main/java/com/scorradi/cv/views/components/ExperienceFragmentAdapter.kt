package com.scorradi.cv.views.components

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.scorradi.cv.views.fragments.ExperienceFragment
import com.scorradi.cv.views.models.ExperienceModel

class ExperienceFragmentAdapter(fragmentManager: FragmentManager, private
                         val experiences: ArrayList<ExperienceModel>): FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {
        return ExperienceFragment.newInstance(experiences[position])
    }

    override fun getCount(): Int {
        return experiences.size
    }

}