package com.naa.uz.viewpagerexample1.adapder

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.naa.uz.viewpagerexample1.ViewPagerFragment
import com.naa.uz.viewpagerexample1.model.ModelViewPager

class ViewPagerAdapter(var data: ArrayList<ModelViewPager>, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Fragment {
        return ViewPagerFragment.newInstance(data[position])
    }
}