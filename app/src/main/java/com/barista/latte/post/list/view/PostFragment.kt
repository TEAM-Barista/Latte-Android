package com.barista.latte.post.list.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.barista.latte.R
import com.barista.latte.activities.main.MainActivity
import com.barista.latte.common.PostAdapter
import com.barista.latte.databinding.CommonTextActionbarBinding
import com.barista.latte.databinding.PostFragmentBinding
import com.barista.latte.post.detail.view.PostDetailActivity
import com.barista.latte.post.list.viewmodels.PostViewModel
import com.barista.latte.views.BaseFragment

class PostFragment : BaseFragment() {

    private lateinit var binding: PostFragmentBinding
    private lateinit var postAdapter : PostAdapter

    companion object {
        fun newInstance() = PostFragment()
    }

    private val viewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.post_fragment, container, false)

        initRecyclerview()
        setDataObserver()

        return binding.root
    }

    override fun setActionBar() {
        val activity = activity ?: return
        var actionBar : ActionBar? = null
        if (activity is MainActivity) {
            actionBar = activity.supportActionBar
        }

        if (actionBar == null) { return }

        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val actionBarBinding = CommonTextActionbarBinding.inflate(LayoutInflater.from(context))
        actionBarBinding.title.text = "Posts"

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
        viewModel.loadData()
    }

    private fun setDataObserver() {
        viewModel.postList.observe(viewLifecycleOwner) { postList ->
            postAdapter.setPostList(postList)
        }
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
}
