package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.android.models.NewsPage
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsPresenter @Inject constructor(private val newsRepository: NewsRepository) : CoroutineBasePresenter<NewsView>() {

    override fun onViewAttached() {
        launch {
            networkRequest(newsRepository.getNewsList()) {
                onResponseSuccessful { response -> onPageLoaded(response!!)
                    // view?.setUpRecycler(response!!)
                }
                onResponseFailed { _, _ -> }
                onCallFailure { }
            }
        }
    }

    private fun onPageLoaded(newsPage: NewsPage) {
        view?.setUpRecycler(newsPage.page)
    }

    fun onSwipeRefresh() {
        launch {
            networkRequest(newsRepository.getNewsList()) {
                onResponseSuccessful { response -> onPageLoaded(response!!)
                }
                onResponseFailed { _, _ -> }
                onCallFailure { }
            }
            view?.stopRefreshing()
        }
    }
}