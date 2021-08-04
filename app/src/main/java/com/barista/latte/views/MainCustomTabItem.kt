package com.barista.latte.views

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.barista.latte.R
import com.barista.latte.databinding.TabItemLayoutBinding
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

/**

 * Created by juhyang on 2021/08/04.

 */

class MainCustomTabItem(context : Context, tabType : TabType) {
    enum class TabType { HOME, INTERVIEW, POST, SEARCH, MY }

    val binding: TabItemLayoutBinding = TabItemLayoutBinding.inflate(LayoutInflater.from(context))

    init {
        val drawableImage : Drawable?
        val tabText : String
        when(tabType) {
            TabType.HOME -> {
                drawableImage = AppCompatResources.getDrawable(context, R.drawable.icon_home_tab)
                tabText = "Home"
            }
            TabType.INTERVIEW -> {
                drawableImage = AppCompatResources.getDrawable(context, R.drawable.icon_interview_tab)
                tabText = "Interview"
            }
            TabType.POST -> {
                drawableImage = AppCompatResources.getDrawable(context, R.drawable.icon_post_tab)
                tabText = "Post"
            }
            TabType.SEARCH -> {
                drawableImage = AppCompatResources.getDrawable(context, R.drawable.icon_search_tab)
                tabText = "Search"
            }
            TabType.MY -> {
                drawableImage = AppCompatResources.getDrawable(context, R.drawable.icon_my_tab)
                tabText = "My"
            }
        }
        binding.tabIcon.setImageDrawable(drawableImage)
        binding.tabText.text = tabText
    }

    fun selectTabLayout() {
        binding.tabAccent.visibility = View.VISIBLE
    }

    fun unSelectTabLayout() {
        binding.tabAccent.visibility = View.INVISIBLE
    }

    fun getView() : View {
        return binding.root
    }
}
