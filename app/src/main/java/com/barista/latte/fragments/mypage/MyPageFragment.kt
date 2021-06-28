package com.barista.latte.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.barista.latte.R
import com.barista.latte.databinding.MyPageFragmentBinding
import com.barista.latte.viewmodels.MyPageViewModel

class MyPageFragment : Fragment() {
    private lateinit var binding: MyPageFragmentBinding

    companion object {
        fun newInstance() = MyPageFragment()
    }

    private val viewModel: MyPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.my_page_fragment, container, false)
        return binding.root
    }
}
