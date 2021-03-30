package ar.com.wolox.android.features.homepage.news

import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsFragmentBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class NewsFragment @Inject constructor() : WolmoFragment<NewsFragmentBinding, NewsPresenter>(), NewsView {

    override fun layout() = R.layout.news_fragment

    override fun init() {
        setUpRecycler()
    }

    private fun setUpRecycler(){
        with(binding) {
            newsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    companion object {
        fun newInstance() = NewsFragment()
    }
}