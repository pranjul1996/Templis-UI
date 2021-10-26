package com.softradix.templis.ui.fragments.tickets.ticketsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.softradix.templis.R
import com.softradix.templis.adapter.TicketAdapter
import com.softradix.templis.databinding.MyTicketsFragmentBinding

class MyTicketsFragment : Fragment() {

    companion object {
        fun newInstance() = MyTicketsFragment()
    }

    private lateinit var viewModel: MyTicketsViewModel
    private lateinit var binding: MyTicketsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyTicketsFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ticketsRv.apply {
            adapter = TicketAdapter(requireActivity()) {
                val nav = findNavController()
                if (nav.currentDestination?.id == R.id.myTicketsFragment) {
                    val action =
                        MyTicketsFragmentDirections.actionMyTicketsFragmentToTicketDetailsFragment()
                    nav.navigate(action)
                }
            }
        }
        onClickEvents()
    }

    private fun onClickEvents() {
        binding.ivBack.setOnClickListener { findNavController().navigateUp() }
    }

}