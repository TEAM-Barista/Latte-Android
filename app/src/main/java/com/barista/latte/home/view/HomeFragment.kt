package com.barista.latte.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.barista.latte.R
import com.barista.latte.common.PostAdapter
import com.barista.latte.databinding.HomeFragmentBinding
import com.barista.latte.home.viewmodels.HomeViewModel

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

        initRecyclerview()
        setDataObserver()

        return binding.root
    }

    private fun initRecyclerview() {
        postAdapter = PostAdapter {  }
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
