package com.softradix.templis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.softradix.templis.R
import com.softradix.templis.data.CastingData
import com.softradix.templis.databinding.CastingItemBinding

class CastingAdapter : RecyclerView.Adapter<CastingAdapter.RecyclerHolder>() {

    private lateinit var binding: CastingItemBinding

    private val list = listOf(
        CastingData("Andre Sebastian", R.drawable.user1),
        CastingData("Vera Farmiga", R.drawable.user3),
        CastingData("Steve Coulter", R.drawable.user4),
        CastingData("Sterling Jerins", R.drawable.user2),
        CastingData("Andre Sebastian", R.drawable.user1),
        CastingData("Steve Coulter", R.drawable.user4),
        CastingData("Vera Farmiga", R.drawable.user3),
        CastingData("Sterling Jerins", R.drawable.user2),


        )

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerHolder {
        binding = CastingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(list[position])

    }

    class RecyclerHolder(var binding: CastingItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(castingData: CastingData) {
            Glide.with(binding.root).load(castingData.image).into(binding.movieImage)
            binding.castName.text = castingData.userName
        }
    }

    override fun getItemCount() = list.size
}