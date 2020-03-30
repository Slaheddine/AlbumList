package me.slaheddine.leboncoin.presentation.utils


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


private var visibleThreshold = 5
fun RecyclerView.addLoadMoreListener(loadMore: () -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            if (dy <= 0) return


            val lastVisibleItem =
                (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()

            if ( (layoutManager?.itemCount ?: 0) <= lastVisibleItem + visibleThreshold) {
                loadMore.invoke()
            }
        }
    })
}





