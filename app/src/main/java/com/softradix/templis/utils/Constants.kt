package com.softradix.templis.utils

import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.softradix.templis.R

object Constants {
    const val SPLASH_DELAY = 1500L
    val imageList = arrayListOf(
        R.drawable.movie,
        R.drawable.movie0,
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
}
fun RecyclerView.smoothSnapToPosition(position: Int, snapMode: Int = LinearSmoothScroller.SNAP_TO_START) {
    val smoothScroller = object : LinearSmoothScroller(this.context) {
        override fun getVerticalSnapPreference(): Int = snapMode
        override fun getHorizontalSnapPreference(): Int = snapMode
    }
    smoothScroller.targetPosition = position
    layoutManager?.startSmoothScroll(smoothScroller)
}