package ar.com.wolox.android.features.homepage.news

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsFragmentBinding
import ar.com.wolox.android.features.homepage.news.details.NewsDetailsActivity
import ar.com.wolox.android.models.NewFromPage
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsFragmentBinding, NewsPresenter>(), NewsView {

    override fun layout() = R.layout.news_fragment

    override fun init() {
    }

    override fun setListeners() {
        with(binding) {
            newsSwipeRefresh.setOnRefreshListener { presenter.onSwipeRefresh() }
            newsRecyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener() {
                override fun onLoadMore(lastVisibleItemPosition: Int) {
                    presenter.onLoadMoreRequested(lastVisibleItemPosition, (newsRecyclerView.adapter as RecyclerAdapter).itemCount)
                }
            })
            (newsRecyclerView.adapter as RecyclerAdapter).setItemsListener(object : OnItemClickListener() {
                override fun onItemClicked(newFromPage: NewFromPage) {
                    presenter.onItemClicked(newFromPage)
                }
            })
        }
    }

    override fun stopRefreshing() {
        with(binding) {
            newsSwipeRefresh.isRefreshing = false
        }
    }

    override fun updateNews(dataSet: List<NewFromPage>) {
        with(binding.newsRecyclerView) {
            (adapter as RecyclerAdapter).addNews(dataSet)
        }
    }

    override fun clearNewsFeed() {
        with(binding.newsRecyclerView) {
            (adapter as RecyclerAdapter).clearData()
        }
    }

    override fun showResponseError() {
        Toast.makeText(requireContext(), getString(R.string.news_server_error), Toast.LENGTH_SHORT).show()
    }

    override fun showCallError() {
        Toast.makeText(requireContext(), getString(R.string.connection_call_error), Toast.LENGTH_SHORT).show()
    }

    override fun goToNewsDetails(newFromPage: NewFromPage, userId: Int) {
        NewsDetailsActivity.start(requireContext(), newFromPage, userId)
    }

    override fun setUpRecycler(userId: Int) {
        with(binding.newsRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = RecyclerAdapter(requireContext(), userId)
        }
    }

    companion object {
        fun newInstance() = NewsFragment()
    }
}