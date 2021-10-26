package com.softradix.templis.ui.fragments.live

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.softradix.templis.adapter.LiveAdapter
import com.softradix.templis.databinding.LiveFragmentBinding

class LiveFragment : Fragment() {

    companion object {
        fun newInstance() = LiveFragment()
    }

    private lateinit var viewModel: LiveViewModel
    private lateinit var binding: LiveFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LiveFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = LiveAdapter(requireActivity()) {
                val action = LiveFragmentDirections.actionLiveFragmentToDetailsFragment()
                findNavController().navigate(action)
            }
        }
        binding.ivBack.setOnClickListener { findNavController().navigateUp() }

    }

}