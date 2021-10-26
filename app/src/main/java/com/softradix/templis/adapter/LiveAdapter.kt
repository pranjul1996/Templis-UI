package com.softradix.templis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.softradix.templis.R
import com.softradix.templis.data.HeaderData
import com.softradix.templis.databinding.RecyclerHeaderBinding

class LiveAdapter(var context: Context,
                  var onClick: () -> Unit) :
    RecyclerView.Adapter<LiveAdapter.RecyclerHolder>() {

    private val HEADER = 1
    private val IMAGES = 2
    private val imageList = arrayListOf(
        R.drawable.movie,
        R.drawable.movie1,
        R.drawable.movie2,
        R.drawable.movie3,
        R.drawable.movie0,
        R.drawable.movie1,
        R.drawable.movie2,
        R.drawable.movie3,
        R.drawable.movie2,
        R.drawable.movie0,
        R.drawable.movie1,
        R.drawable.movie2,
        R.drawable.movie3
    )

    private lateinit var binding: RecyclerHeaderBinding

    private var mDataList: ArrayList<HeaderData> = arrayListOf(
        HeaderData(title = "Live Concert/Music/Podcast", imageList),
        HeaderData(title = "Live Shows", imageList),
        HeaderData(title = "Theatre Drama", imageList)
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerHolder {
        binding = RecyclerHeaderBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return RecyclerHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.bind(mDataList[position],onClick)
    }


    //    override fun getItemViewType(position: Int): Int {
//        return if (mDataList[position] is HeaderData){
//            HEADER
//        }else{
//            IMAGES
//        }
//    }
    inner class RecyclerHolder(var binding: RecyclerHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HeaderData,onClick: () -> Unit) {
            binding.appCompatTextView.text = item.title
            binding.imagesList.apply {
                layoutManager = LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL, false
                )
                adapter = SlidingAdapter {
                    onClick()
                }

            }
        }
    }

    override fun getItemCount() = mDataList.size
}