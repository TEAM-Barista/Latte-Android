package com.barista.latte.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.barista.latte.R
import com.barista.latte.databinding.ActivityMainBinding
import com.barista.latte.fragments.board.BoardFragment
import com.barista.latte.fragments.home.HomeFragment
import com.barista.latte.fragments.interview.InterviewFragment
import com.barista.latte.fragments.mypage.MyPageFragment
import com.barista.latte.fragments.search.SearchFragment
import com.barista.latte.views.LatteActionBar
import com.google.android.material.tabs.TabLayout




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val interviewFragment by lazy { InterviewFragment.newInstance() }
    val searchFragment by lazy { SearchFragment.newInstance() }
    val homeFragment by lazy { HomeFragment.newInstance() }
    val boardFragment by lazy { BoardFragment.newInstance() }
    val myPageFragment by lazy { MyPageFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, com.barista.latte.R.layout.activity_main)

        setCustomActionBar()
        setFragment()
        aboutView()
    }

    private fun setCustomActionBar() {
        val actionBar = supportActionBar ?: return

        LatteActionBar(this, actionBar).setActionBar()
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
                    1 -> {
                        interviewFragment
                    }
                    0 -> {
                        homeFragment
                    }
                    2 -> {
                        boardFragment
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
