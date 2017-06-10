package com.lemonclub.pinbox

import android.app.Activity
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.lemonclub.pinbox.data.PinPostAdapter
import com.lemonclub.pinbox.data.PinPostData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val menus: Array<String> = arrayOf("핀 홈", "박 스", "검 색", "메세지")

    inner class SectionPinPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        val fragments = ArrayList<Fragment>()
        fun addFragment(fragment: Fragment) = fragments.add(fragment)
        override fun getItem(position: Int): Fragment = fragments.get(position)
        override fun getCount(): Int = fragments.size
    }

    lateinit var sectionsPagerAdapter: SectionPinPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        tabs.addTab(tabs.newTab().setText("핀 홈"))
        tabs.addTab(tabs.newTab().setText("박 스"))
        tabs.addTab(tabs.newTab().setText("검 색"))
        tabs.addTab(tabs.newTab().setText("메세지"))

        sectionsPagerAdapter = SectionPinPagerAdapter(supportFragmentManager)
        sectionsPagerAdapter.addFragment(PinHomeFragment())
        sectionsPagerAdapter.addFragment(PinHomeFragment())
        sectionsPagerAdapter.addFragment(PinHomeFragment())
        sectionsPagerAdapter.addFragment(PinHomeFragment())

        container.adapter = sectionsPagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                container.currentItem = tab!!.position
                toolbar.title = menus.get(tab.position)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}