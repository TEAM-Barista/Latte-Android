package com.barista.latte.search.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.barista.latte.MainActivity
import com.barista.latte.R
import com.barista.latte.databinding.CommonTextActionbarBinding
import com.barista.latte.databinding.SearchFragmentBinding
import com.barista.latte.home.view.HomeFragment
import com.barista.latte.search.viewmodels.SearchViewModel
import com.barista.latte.views.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment() {
    private lateinit var binding: SearchFragmentBinding

    companion object {
        fun newInstance() : SearchFragment {
            val fragment = SearchFragment()
            val bundle = Bundle()
            fragment.arguments = bundle

            return fragment
        }
    }

    private val viewModel: SearchViewModel by viewModels()

    override fun setActionBar() {
        val activity = activity ?: return
        var actionBar: ActionBar? = null
        if (activity is MainActivity) {
            actionBar = activity.supportActionBar
        }

        if (actionBar == null) {
            return
        }

        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val actionBarBinding = CommonTextActionbarBinding.inflate(LayoutInflater.from(context))
        actionBarBinding.title.text = "Search"

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
        return binding.root
    }
}
