package ar.com.wolox.android.features.homepage.news

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class EndlessRecyclerViewScrollListener() : RecyclerView.OnScrollListener() {

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        val lastVisibleItemPosition = (view.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
        onLoadMore(lastVisibleItemPosition)
    }

    abstract fun onLoadMore(lastVisibleItemPosition: Int)
}