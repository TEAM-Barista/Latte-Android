package com.barista.latte.post.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.barista.latte.MainActivity
import com.barista.latte.databinding.CommonTextActionbarBinding
import com.barista.latte.databinding.PostListFragmentBinding
import com.barista.latte.post.detail.PostDetailActivity
import com.barista.latte.views.BaseFragment

class PostListFragment : BaseFragment() {

    private var _binding: PostListFragmentBinding? = null // View 의

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!! // binding 이 nullable 이기 때문에 ? 를 없애기 위한 Getter
    private val postListAdapter: PostListAdapter by lazy { PostListAdapter { post ->
        val intent = Intent (requireContext(), PostDetailActivity::class.java)
        intent.putExtra(PostDetailActivity.POST_KEY, post.id)
        requireActivity().startActivity(intent)
    } }

    companion object {
        fun newInstance() = PostListFragment()
    }

    private val listViewModel: PostListViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = PostListFragmentBinding.inflate(inflater, container, false)

        initRecyclerview()
        setDataObserver()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

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
        actionBarBinding.title.text = "Posts"

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
        listViewModel.loadData()
    }

    private fun setDataObserver() {
        listViewModel.postList.observe(viewLifecycleOwner) { postList ->
            postListAdapter.submitList(postList)
        }
    }

    private fun initRecyclerview() {
        binding.postRecyclerView.apply {
            adapter = postListAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
