package com.softradix.templis.ui.fragments.tickets.ticketDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.softradix.templis.databinding.TicketDetailsFragmentBinding

class TicketDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = TicketDetailsFragment()
    }

    private lateinit var viewModel: TicketDetailsViewModel
    private lateinit var binding: TicketDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = TicketDetailsFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener { findNavController().navigateUp() }
    }

}