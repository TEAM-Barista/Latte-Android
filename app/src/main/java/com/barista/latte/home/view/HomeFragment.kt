package com.barista.latte.home.view

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




class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null

    private val binding get() = _binding!! // binding 이 nullable 이기 때문에 ? 를 없애기 위한 Getter
    private val postAdapter : PostAdapter by lazy { PostAdapter {} }

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
        loadData()

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        setActionBar()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
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
        binding.postRecyclerView.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setDataObserver() {
        viewModel.postList.observe(viewLifecycleOwner) { postList ->
            postAdapter.submitList(postList)
        }
    }
}
