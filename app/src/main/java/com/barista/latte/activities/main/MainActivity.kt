package com.barista.latte.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.barista.latte.R
import com.barista.latte.databinding.ActivityMainBinding
import com.barista.latte.fragments.board.BoardFragment
import com.barista.latte.fragments.home.HomeFragment
import com.barista.latte.fragments.interview.InterviewFragment
import com.barista.latte.fragments.mypage.MyPageFragment
import com.barista.latte.fragments.search.SearchFragment
import com.google.android.material.tabs.TabLayout




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val homeFragment by lazy { HomeFragment.newInstance() }
    val interviewFragment by lazy { InterviewFragment.newInstance() }
    val boardFragment by lazy { BoardFragment.newInstance() }
    val searchFragment by lazy { SearchFragment.newInstance() }
    val myPageFragment by lazy { MyPageFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setFragment()
        aboutView()
    }

    private fun setFragment() {
        val transaction = supportFragmentManager.beginTransaction()
            .add(R.id.main_frameLayout, homeFragment)
        transaction.commit()

        binding.mainTabLayout.selectTab(binding.mainTabLayout.getTabAt(0))
    }

    private fun aboutView() {
        binding.mainTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab ?: return
                val selectedFragment = when (tab.position) {
                    0 -> {
                        homeFragment
                    }
                    1 -> {
                        interviewFragment
                    }
                    2 -> {
                        boardFragment
                    }
                    3 -> {
                        searchFragment
                    }
                    4 -> {
                        myPageFragment
                    }
                    else -> {
                        return
                    }
                }
                changeFragment(selectedFragment)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun changeFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragment).commit()
    }
}
