package ar.com.wolox.android.features.homepage.news

import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsFragmentBinding
import ar.com.wolox.android.models.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsFragmentBinding, NewsPresenter>(), NewsView {

    override fun layout() = R.layout.news_fragment

    override fun init() {
        setUpRecycler()
    }

    override fun setListeners() {
        with(binding) {
            newsSwipeRefresh.setOnRefreshListener {
                presenter.onSwipeRefresh()
            }
        }
    }

    override fun stopRefreshing() {
        with(binding) {
            newsSwipeRefresh.isRefreshing = false
        }
    }

    private fun setUpRecycler() {
        with(binding) {
            with(newsRecyclerView) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = RecyclerAdapter(emulateDataSet())
            }
        }
    }

    private fun emulateDataSet(): Array<News> {
        return arrayOf(
            News(
                getString(R.string.title_placeholder),
                getString(R.string.description_placeholder),
                true,
                getString(R.string.time_placeholder),
                getString(R.string.image_description)
            ),
            News(
                getString(R.string.title_placeholder),
                getString(R.string.description_placeholder),
                true,
                getString(R.string.time_placeholder),
                getString(R.string.image_description)
            ),
            News(
                getString(R.string.title_placeholder),
                getString(R.string.description_placeholder),
                true,
                getString(R.string.time_placeholder),
                getString(R.string.image_description)
            ),
            News(
                getString(R.string.title_placeholder),
                getString(R.string.description_placeholder),
                true,
                getString(R.string.time_placeholder),
                getString(R.string.image_description)
            ),
            News(
                getString(R.string.title_placeholder),
                getString(R.string.description_placeholder),
                true,
                getString(R.string.time_placeholder),
                getString(R.string.image_description)
            ),
            News(
                getString(R.string.title_placeholder),
                getString(R.string.description_placeholder),
                true,
                getString(R.string.time_placeholder),
                getString(R.string.image_description)
            ),
            News(
                getString(R.string.title_placeholder),
                getString(R.string.description_placeholder),
                true,
                getString(R.string.time_placeholder),
                getString(R.string.image_description)
            )
        )
    }

    companion object {
        fun newInstance() = NewsFragment()
    }
}