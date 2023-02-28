package com.app.officemanager.ui.activities.home_dashboard

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener
import androidx.viewpager2.widget.ViewPager2.*
import com.app.officemanager.R
import com.app.officemanager.databinding.ActivityHomeDashboardBinding
import com.app.officemanager.ui.activities.BaseActivity
import com.app.officemanager.ui.adapters.HomeViewPagerAdapter
import com.app.officemanager.ui.fragments.home.HomeFragment
import com.app.officemanager.ui.fragments.leave.LeaveFragment
import com.app.officemanager.ui.fragments.navigation_drawer.NavigationDrawerFragment
import com.app.officemanager.utils.Utils.getCurrentFragment
import com.app.officemanager.utils.Utils.replaceFragment
import com.google.android.material.navigation.NavigationBarView
import java.util.Stack


class HomeDashboardActivity : BaseActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityHomeDashboardBinding
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter
    private lateinit var stack: Stack<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initListener()
    }

    override fun initView() {
        stack = Stack()
        stack.push(0)
        homeViewPagerAdapter = HomeViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.apply {
            bottomNavigation.menu.getItem(1).isChecked = true
            pager.adapter = homeViewPagerAdapter
        }
        selectFragment(1)
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.drawerContainer, NavigationDrawerFragment())
        ft.commit()
    }

    override fun initListener() {
        binding.apply {
            bottomNavigation.setOnItemSelectedListener(this@HomeDashboardActivity)
            drawerLayout.addDrawerListener(object : DrawerListener {
                override fun onDrawerSlide(arg0: View, arg1: Float) {}
                override fun onDrawerStateChanged(arg0: Int) {}
                override fun onDrawerOpened(arg0: View) {}
                override fun onDrawerClosed(arg0: View) {
                    setbackTrackFragment(null)
                    bottomNavigation.menu.getItem(pager.currentItem+1).isChecked = true
                }
            })
            pager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
                private var settled = false
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when(position) {
                        0 -> {
                            //stack.push(0)
                            bottomNavigation.menu.getItem(1).isChecked = true
                        }
                        1 -> {
                            //stack.push(1)
                            bottomNavigation.menu.getItem(2).isChecked = true
                        }
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)
                    if (state == SCROLL_STATE_DRAGGING) {
                        settled = false
                    }
                    if (state == SCROLL_STATE_SETTLING) {
                        settled = true
                    }
                    if (state == SCROLL_STATE_IDLE && !settled) {
                        if (pager.currentItem == 0) {
                            drawerLayout.openDrawer(GravityCompat.START)
                            bottomNavigation.menu.getItem(0).isChecked = true
                        }
                    }
                }
            })
        }
    }

    override fun initObserver() {
        TODO("Not yet implemented")
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

    override fun onBackPressed() {
        try {
            binding.apply {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    val count = supportFragmentManager.backStackEntryCount
                    if (stack.size == 1) {
                        moveTaskToBack(true)
                    } else {
                        stack.pop()
                        setbackTrackFragment(stack.lastElement())
                    }

                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuItemDrawer -> {
                selectFragment(0)
            }
            R.id.menuItemHome -> {
                selectFragment(1)
            }
            R.id.menuItemLeave -> {
                selectFragment(2)
            }
        }

        return true
    }

    private fun selectFragment(index: Int) {
        binding.apply {
            when (index) {
                //drawer menu
                0 -> {
                    drawerLayout.openDrawer(GravityCompat.START)
                }
                //home
                1 -> {
                    if (stack.lastElement() != 0)
                        stack.push(0)
                    pager.setCurrentItem(0, true)
                    //replaceFragment(supportFragmentManager, HomeFragment(), R.id.container)
                }
                //leave
                2 -> {
                    if (stack.lastElement() != 1)
                        stack.push(1)
                    pager.setCurrentItem(1, true)
                    //replaceFragment(supportFragmentManager, LeaveFragment(), R.id.container)
                }
            }
        }
    }

    private fun setbackTrackFragment(position: Int?) {
        binding.apply {
            when(position) {
                0 -> {
                    pager.setCurrentItem(0, true)
                    bottomNavigation.menu.getItem(1).isChecked = true
                }
                1 -> {
                    pager.setCurrentItem(1, true)
                    bottomNavigation.menu.getItem(2).isChecked = true
                }
            }
            /*if (getCurrentFragment(
                    supportFragmentManager,
                    R.id.container
                ) is HomeFragment
            ) {
                bottomNavigation.menu.getItem(1).isChecked = true
            } else if (getCurrentFragment(
                    supportFragmentManager,
                    R.id.container
                ) is LeaveFragment
            ) {
                bottomNavigation.menu.getItem(2).isChecked = true
            }*/
        }
    }

}