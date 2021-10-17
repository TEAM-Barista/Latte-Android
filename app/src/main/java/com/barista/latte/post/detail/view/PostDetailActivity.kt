package com.barista.latte.post.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import com.barista.latte.databinding.ActivityPostDetailBinding
import com.barista.latte.databinding.PostDetailActionbarBinding
import com.barista.latte.post.detail.viewmodels.PostDetailViewModel
import com.barista.latte.views.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostDetailActivity : BaseActivity() {

    private lateinit var binding: ActivityPostDetailBinding
    val viewModel: PostDetailViewModel by viewModels()

    companion object {
        const val POST_KEY = "POST_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailBinding.inflate(layoutInflater)
        binding.viewModel = viewModel

        setContentView(binding.root)
    }

    override fun setActionBar() {
        val actionBar = supportActionBar ?: return

        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayShowTitleEnabled(false)
        actionBar.setDisplayHomeAsUpEnabled(false)

        val actionBarBinding = PostDetailActionbarBinding.inflate(LayoutInflater.from(this))

        actionBarBinding.backButton.setOnClickListener {
            onBackPressed()
        }

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
        val postId = intent.getLongExtra(POST_KEY, -1L)
        if (postId == -1L) {
            return
        }
        viewModel.loadData(postId)
    }
}
