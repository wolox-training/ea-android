package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.android.models.NewsPage
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsRepository: NewsRepository) : CoroutineBasePresenter<NewsView>() {

    private var nextPage: Int? = null
    private var totalPages: Int? = null
    private var loading: Boolean = true

    override fun onViewAttached() {
        requestFirstPage()
    }

    fun onSwipeRefresh() {
        requestFirstPage()
        view?.stopRefreshing()
    }

    fun onLoadMoreRequested(lastVisibleItemPosition: Int, dataSetSize: Int) {
        if (!loading && (lastVisibleItemPosition + VISIBLE_THRESHOLD) > dataSetSize && nextPage!! <= totalPages!!) {
            loading = true
            requestPage(nextPage)
        }
    }

    private fun requestFirstPage() {
        requestPage(null)
    }

    private fun requestPage(page: Int?) {
        launch {
            networkRequest(newsRepository.getNewsList(page)) {
                onResponseSuccessful { response ->
                    if (page == null) {
                        view?.clearNewsFeed()
                    }
                    onPageLoaded(response!!)
                }
                onResponseFailed { _, _ -> view?.showResponseError() }
                onCallFailure { view?.showCallError() }
            }
            loading = false
        }
    }

    private fun onPageLoaded(newsPage: NewsPage) {
        totalPages = newsPage.total_pages
        nextPage = newsPage.next_page
        view?.updateNews(newsPage.page)
    }

    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }
}