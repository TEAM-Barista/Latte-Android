package com.barista.latte.mypage.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.barista.latte.databinding.CommonTextActionbarBinding
import com.barista.latte.databinding.MyPageFragmentBinding
import com.barista.latte.mypage.viewmodels.MyPageViewModel
import com.barista.latte.views.BaseFragment

class MyPageFragment : BaseFragment() {
    private var _binding: MyPageFragmentBinding? = null
    private val binding get() = _binding!! // binding 이 nullable 이기 때문에 ? 를 없애기 위한 Getter
    companion object {
        fun newInstance() = MyPageFragment()
    }

    private val viewModel: MyPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MyPageFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel

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

        val actionBarBinding = CommonTextActionbarBinding.inflate(LayoutInflater.from(context))
        actionBarBinding.title.text = "내 정보"

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
        viewModel.loadData()
    }
}
