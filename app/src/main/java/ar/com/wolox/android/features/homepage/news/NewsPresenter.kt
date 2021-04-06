package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.android.models.NewsPage
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsRepository: NewsRepository) : CoroutineBasePresenter<NewsView>() {

    private var nextPage: Int? = null

    override fun onViewAttached() {
        requestFirstPage()
    }

    fun onSwipeRefresh() {
        requestFirstPage()
        view?.stopRefreshing()
    }

    fun onLoadMoreRequested() {
        requestPage(nextPage)
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
        }
    }

    private fun onPageLoaded(newsPage: NewsPage) {
        nextPage = newsPage.next_page
        view?.updateNews(newsPage.page)
    }
}