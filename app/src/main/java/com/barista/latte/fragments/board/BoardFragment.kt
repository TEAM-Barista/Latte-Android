package com.barista.latte.fragments.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.barista.latte.R
import com.barista.latte.databinding.BoardFragmentBinding
import com.barista.latte.viewmodels.BoardViewModel

class BoardFragment : Fragment() {
    private lateinit var binding: BoardFragmentBinding

    companion object {
        fun newInstance() = BoardFragment()
    }

    private val viewModel: BoardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.board_fragment, container, false)
        return binding.root
    }
}
