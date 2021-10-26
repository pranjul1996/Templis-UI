package com.softradix.templis.ui.fragments.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.softradix.templis.adapter.PaymentCardAdapter
import com.softradix.templis.databinding.PaymentsFragmentBinding

class PaymentsFragment : Fragment() {

    companion object {
        fun newInstance() = PaymentsFragment()
    }

    private lateinit var viewModel: PaymentsViewModel
    private lateinit var binding: PaymentsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PaymentsFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        onClickEvents()

    }

    private fun setUpRecyclerView() {
        binding.paymentRv.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = PaymentCardAdapter()
        }
    }

    private fun onClickEvents() {
        binding.ivBack.setOnClickListener { findNavController().navigateUp() }

    }

}