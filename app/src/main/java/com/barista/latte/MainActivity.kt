package com.barista.latte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.barista.latte.databinding.ActivityMainBinding
import com.barista.latte.post.list.PostListFragment
import com.barista.latte.home.view.HomeFragment
import com.barista.latte.interview.view.InterviewFragment
import com.barista.latte.mypage.view.MyPageFragment
import com.barista.latte.fragments.search.SearchFragment
import com.barista.latte.views.MainCustomTabItem
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val homeFragment by lazy { HomeFragment.newInstance() }
    val interviewFragment by lazy { InterviewFragment.newInstance() }
    val boardFragment by lazy { PostListFragment.newInstance() }
    val searchFragment by lazy { SearchFragment.newInstance() }
    val myPageFragment by lazy { MyPageFragment.newInstance() }

    val tabItemList : ArrayList<MainCustomTabItem> = ArrayList()
    val fragmentList : ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initFragmentList()
        initTabLayout()

        setFragment()
        aboutView()
    }

    private fun initFragmentList() {
        fragmentList.add(homeFragment)
        fragmentList.add(interviewFragment)
        fragmentList.add(boardFragment)
        fragmentList.add(searchFragment)
        fragmentList.add(myPageFragment)
    }

    private fun initTabLayout() {
        tabItemList.add(MainCustomTabItem(this, MainCustomTabItem.TabType.HOME))
        tabItemList.add(MainCustomTabItem(this, MainCustomTabItem.TabType.INTERVIEW))
        tabItemList.add(MainCustomTabItem(this, MainCustomTabItem.TabType.POST))
        tabItemList.add(MainCustomTabItem(this, MainCustomTabItem.TabType.SEARCH))
        tabItemList.add(MainCustomTabItem(this, MainCustomTabItem.TabType.MY))

        for (i in 0 until tabItemList.size) {
            binding.mainTabLayout.getTabAt(i)?.customView = tabItemList[i].getView()
        }
    }

    private fun setFragment() {
        val transaction = supportFragmentManager.beginTransaction()
                .add(R.id.main_frameLayout, homeFragment)
        transaction.commit()

        binding.mainTabLayout.selectTab(binding.mainTabLayout.getTabAt(0))
        tabItemList[0].selectTabLayout()
    }

    private fun aboutView() {
        binding.mainTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab ?: return
                changeFragment(fragmentList[tab.position])

                val tabItem = tabItemList[tab.position]
                tabItem.selectTabLayout()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab ?: return

                val tabItem = tabItemList[tab.position]
                tabItem.unSelectTabLayout()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.main_frameLayout, fragment).commit()
    }
}
