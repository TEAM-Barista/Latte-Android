package com.barista.latte.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.barista.latte.post.list.view.PostListAdapter
import com.barista.latte.databinding.HomeFragmentBinding
import com.barista.latte.home.viewmodels.HomeViewModel
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.barista.latte.databinding.LogoActionbarBinding
import com.barista.latte.models.post.TabStatus
import com.barista.latte.views.BaseFragment
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private var _binding: HomeFragmentBinding? = null

    private val binding get() = _binding!! // binding 이 nullable 이기 때문에 ? 를 없애기 위한 Getter
    private val postListAdapter : PostListAdapter by lazy { PostListAdapter {} }

    companion object {
        fun newInstance() : HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            fragment.arguments = bundle

            return fragment
        }
    }

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)

        binding.homeViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initRecyclerview()
        setDataObserver()

        aboutView()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun setActionBar() {
        val actionBar = (requireActivity() as AppCompatActivity).supportActionBar ?: return

        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val actionBarBinding = LogoActionbarBinding.inflate(LayoutInflater.from(context))

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
        viewModel.loadData()
    }

    private fun initRecyclerview() {
        binding.postRecyclerView.apply {
            adapter = postListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setDataObserver() {
        viewModel.postList.observe(viewLifecycleOwner) { postList ->
            postListAdapter.submitList(postList)
        }
    }

    private fun aboutView() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab ?: return
                if (tab.position == 0) {
                    viewModel.setPostList(TabStatus.QUESTION)
                } else {
                    viewModel.setPostList(TabStatus.COMMUNITY)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}
