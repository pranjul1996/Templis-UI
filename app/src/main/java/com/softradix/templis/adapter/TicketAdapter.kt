package com.softradix.templis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.softradix.templis.data.TicketData
import com.softradix.templis.databinding.TicketListItemBinding

class TicketAdapter(var context: Context, var onClick: (TicketData) -> Unit) :
    RecyclerView.Adapter<TicketAdapter.TickerHolder>() {

    private lateinit var binding: TicketListItemBinding

    private var ticketList = listOf(
        TicketData("The Sinner", "One User", true),
        TicketData("The Sinner", "One User", false),
        TicketData("The Sinner", "Five User", false),
        TicketData("The Sinner", "Two User", true),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TickerHolder {
        binding = TicketListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TickerHolder(binding)

    }

    override fun onBindViewHolder(holder: TickerHolder, position: Int) {
        holder.bind(ticketList[position], onClick, context)
    }

    class TickerHolder(var binding: TicketListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(ticketList: TicketData, onClick: (TicketData) -> Unit, context: Context) {
            binding.name.text = ticketList.title
            binding.totalUsers.text = ticketList.persons
            if (ticketList.isExpired == true) {
                binding.validation.text = "Expired!"
                binding.validation.setTextColor(
                    ContextCompat.getColor(
                        context,
                        android.R.color.holo_red_dark
                    )
                )

            } else {
                binding.validation.text = "Valid for only 3hours"
                binding.validation.setTextColor(
                    ContextCompat.getColor(
                        context,
                        android.R.color.white
                    )
                )

            }

            binding.root.setOnClickListener {
                onClick(ticketList)
            }
        }

    }

    override fun getItemCount() = ticketList.size
}