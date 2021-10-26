package com.softradix.templis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.softradix.templis.R
import com.softradix.templis.data.HeaderData
import com.softradix.templis.databinding.RecyclerListItemBinding
import com.softradix.templis.utils.Constants.imageList

class SlidingAdapter(var onClick: () -> Unit) :
    RecyclerView.Adapter<SlidingAdapter.RecyclerHolder>() {

    private val HEADER = 1
    private val IMAGES = 2



    private lateinit var binding: RecyclerListItemBinding
    private var mDataList: ArrayList<Any> = arrayListOf(
        HeaderData(title = "In Cinemas"),
        imageList,
        HeaderData(title = "In Cinemas"),
        imageList,
        HeaderData(title = "In Cinemas"), imageList
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerHolder {
        binding = RecyclerListItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return RecyclerHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(imageList[position], onClick)
    }

    /*   override fun getItemViewType(position: Int): Int {
           return if (mDataList[position] is HeaderData){
               HEADER
           }else{
               IMAGES
           }
       }*/
    class RecyclerHolder(var binding: RecyclerListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageItem: Int, onClick: () -> Unit) {
            binding.movieImage.apply {
                setImageResource(imageItem)
                setOnClickListener {
                    onClick()
                }
            }
        }
    }

    override fun getItemCount() = imageList.size
}