package com.barista.latte.interview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.barista.latte.databinding.InterviewFragmentBinding
import com.barista.latte.databinding.LogoActionbarBinding
import com.barista.latte.interview.viewmodels.InterviewViewModel
import com.barista.latte.views.BaseFragment

class InterviewFragment : BaseFragment() {
    private var _binding: InterviewFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = InterviewFragment()
    }

    private val viewModel: InterviewViewModel by viewModels()

    private val newInterviewAdapter by lazy { NewInterviewAdapter() }
    private val priorInterviewAdapter by lazy { PriorInterviewAdapter() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = InterviewFragmentBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        initRecyclerView()
        setObserver()

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

        val actionBarBinding = LogoActionbarBinding.inflate(LayoutInflater.from(context))

        val params = ActionBar.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)

        actionBar.setCustomView(actionBarBinding.root, params)
    }

    override fun loadData() {
        viewModel.loadData()
    }

    private fun initRecyclerView() {
        val newInterviewLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.newInterviewRecyclerView.apply {
            this.adapter = newInterviewAdapter
            this.layoutManager = newInterviewLayoutManager
        }

        val priorInterviewLayoutManager = LinearLayoutManager(requireContext())
        binding.priorInterviewRecyclerView.apply {
            this.adapter = priorInterviewAdapter
            this.layoutManager = priorInterviewLayoutManager
        }
    }

    fun setObserver() {
        viewModel.newInterviewList.observe(viewLifecycleOwner) { interviewList ->
            newInterviewAdapter.submitList(interviewList)
        }

        viewModel.priorInterviewList.observe(viewLifecycleOwner) { interviewList ->
            priorInterviewAdapter.submitList(interviewList)
        }
    }
}
