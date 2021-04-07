package ar.com.wolox.android.features.homepage.news.details

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsDetailsFragmentBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class NewsDetailsFragment : WolmoFragment<NewsDetailsFragmentBinding, NewsDetailsPresenter>(), NewsDetailsView {

    override fun layout() = R.layout.news_details_fragment

    override fun init() {
    }

    override fun setListeners() {
        with(binding) {
            newsSwipeRefresh.setOnRefreshListener { }
            likeRadioButton.setOnClickListener { }
        }
    }

    companion object {
        fun newInstance() = NewsDetailsFragment()
    }
}