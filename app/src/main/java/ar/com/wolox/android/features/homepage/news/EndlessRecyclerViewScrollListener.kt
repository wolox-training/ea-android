package ar.com.wolox.android.features.homepage.news

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerViewScrollListener() : RecyclerView.OnScrollListener() {
    // The minimum amount of items to have below your current scroll position
    // before loading more.
    private val visibleThreshold = 5

    // The total number of items in the dataset after the last load
    private var previousTotalItemCount = 0

    // True if we are still waiting for the last set of data to load.
    private var loading = true

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        val lastVisibleItemPosition = (view.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        val totalItemCount = (view.layoutManager as LinearLayoutManager).itemCount

        if (loading) {
            if (totalItemCount > previousTotalItemCount) {
                loading = false
                previousTotalItemCount = totalItemCount
            }
        }

        if (!loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount) {
            loading = true
            onLoadMore()
        }
    }

    abstract fun onLoadMore()
}