package com.softradix.templis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softradix.templis.databinding.CardListItemBinding

class PaymentCardAdapter : RecyclerView.Adapter<PaymentCardAdapter.ViewHolder>() {

    private lateinit var binding: CardListItemBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        binding =
            CardListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    inner class ViewHolder(var binding: CardListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {

        }
    }


    override fun getItemCount() = 1
}