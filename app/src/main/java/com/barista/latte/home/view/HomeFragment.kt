package com.barista.latte.home.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.barista.latte.R
import com.barista.latte.activities.main.MainActivity
import com.barista.latte.common.PostAdapter
import com.barista.latte.databinding.HomeActionbarBinding
import com.barista.latte.databinding.HomeFragmentBinding
import com.barista.latte.home.viewmodels.HomeViewModel
import android.widget.LinearLayout
import com.barista.latte.post.detail.view.PostDetailActivity


class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var postAdapter : PostAdapter

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        binding.homeViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initRecyclerview()
        setDataObserver()
        loadData()

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        setActionBar()
    }

    private fun setActionBar() {
        val activity = activity ?: return
        var actionBar : ActionBar? = null
        if (activity is MainActivity) {
            actionBar = activity.supportActionBar
        }

        if (actionBar == null) { return }

        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val actionBarBinding = HomeActionbarBinding.inflate(LayoutInflater.from(context))

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    private fun loadData() {
        viewModel.loadData()
    }

    private fun initRecyclerview() {
        postAdapter = PostAdapter { post ->
            val intent = Intent(requireContext(), PostDetailActivity::class.java)
            intent.putExtra(PostDetailActivity.POST_KEY, post)
            requireActivity().startActivity(intent)
        }
        val layoutManager = LinearLayoutManager(requireContext())
        binding.postRecyclerView.adapter = postAdapter
        binding.postRecyclerView.layoutManager = layoutManager
    }

    private fun setDataObserver() {
        viewModel.postList.observe(viewLifecycleOwner) { postList ->
            postAdapter.setPostList(postList)
        }
    }
}
