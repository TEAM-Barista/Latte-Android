package com.barista.latte.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.barista.latte.post.list.PostListAdapter
import com.barista.latte.databinding.HomeFragmentBinding
import com.barista.latte.home.viewmodels.HomeViewModel
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.barista.latte.databinding.LogoActionbarBinding
import com.barista.latte.views.BaseFragment


class HomeFragment : BaseFragment() {

    private var _binding: HomeFragmentBinding? = null

    private val binding get() = _binding!! // binding 이 nullable 이기 때문에 ? 를 없애기 위한 Getter
    private val postListAdapter : PostListAdapter by lazy { PostListAdapter {} }

    companion object {
        fun newInstance() = HomeFragment()
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
}
