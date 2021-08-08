package com.barista.latte.fragments.interview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.barista.latte.R
import com.barista.latte.databinding.InterviewFragmentBinding
import com.barista.latte.viewmodels.InterviewViewModel

class InterviewFragment : Fragment() {
    private lateinit var binding: InterviewFragmentBinding

    companion object {
        fun newInstance() = InterviewFragment()
    }

    private val viewModel: InterviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.interview_fragment, container, false)
        return binding.root
    }
}
