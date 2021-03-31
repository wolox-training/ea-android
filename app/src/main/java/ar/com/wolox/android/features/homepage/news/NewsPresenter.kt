package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import javax.inject.Inject

class NewsPresenter @Inject constructor() : CoroutineBasePresenter<NewsView>() {
    fun onSwipeRefresh() {
        view?.stopRefreshing()
    }
}