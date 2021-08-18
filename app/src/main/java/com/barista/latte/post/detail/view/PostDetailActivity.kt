package com.barista.latte.post.detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import com.barista.latte.R
import com.barista.latte.databinding.ActivityPostDetailBinding
import com.barista.latte.databinding.PostDetailActionbarBinding
import com.barista.latte.post.detail.viewmodels.PostDetailViewModel
import com.barista.latte.views.BaseActivity

class PostDetailActivity : BaseActivity() {

    lateinit var binding : ActivityPostDetailBinding
    private val viewModel : PostDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_detail)
    }

    override fun setActionBar() {
        val actionBar = supportActionBar ?: return

        actionBar.setDisplayShowCustomEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(false)
        actionBar.setDisplayShowTitleEnabled(false)

        val actionBarBinding = PostDetailActionbarBinding.inflate(LayoutInflater.from(this))

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
        viewModel.loadData()
    }
}
