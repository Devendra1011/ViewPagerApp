package com.example.viewpagerapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentManager:FragmentManager,lifecycle:Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {

    var fragmentsList:ArrayList<Fragment> = ArrayList()


    fun addFragmentToList(fragment:Fragment){
        fragmentsList.add(fragment)
    }

    override fun getItemCount(): Int {
        // returns the total number of items in your viewpager2
        return fragmentsList.size

    }

    override fun createFragment(position: Int): Fragment {
        // Responsible for creating and returning a Fragment
        // for a specific position within ViewPager
        return fragmentsList.get(position)
    }
}