package com.example.viewpagerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var pagerAdapter: MyPagerAdapter
    lateinit var tabLayout:TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        viewPager = findViewById(R.id.view_pager)
        viewPager.orientation = (ViewPager2.ORIENTATION_HORIZONTAL)

        // 2- Add Fragment to the list in the Adapter Class
        pagerAdapter = MyPagerAdapter(supportFragmentManager, lifecycle)
        pagerAdapter.addFragmentToList(FragmentOne())
        pagerAdapter.addFragmentToList(FragmentTwo())
        pagerAdapter.addFragmentToList(FragmentThree())

        // 3- Connecting the adapter with ViewPager2

        viewPager.adapter =pagerAdapter
        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout,viewPager){ tab,position ->

            tab.text = "Tab ${position+1}"
        }.attach()
    }
}