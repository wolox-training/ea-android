package ar.com.wolox.android.features.homepage.news.details

import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.NewsRepository
import ar.com.wolox.android.models.NewFromDetails
import ar.com.wolox.android.utils.UserSession
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsDetailsPresenter @Inject constructor(private val newsRepository: NewsRepository, private val userSession: UserSession) : CoroutineBasePresenter<NewsDetailsView>() {

    private var loading = false

    fun onSwipeRefresh(id: Int) {
        launch {
            networkRequest(newsRepository.getNewById(id)) {
                onResponseSuccessful { response -> formatData(response!!) }
                onResponseFailed { _, _ -> view?.onResponseFailed() }
                onCallFailure { view?.onCallFailed() }
            }
            view?.stopRefreshing()
        }
    }

    private fun formatData(newFromDetails: NewFromDetails) {
        with(newFromDetails) {
            val isLiked = userSession.id in likes
            view?.updateData(commenter, comment, isLiked)
        }
    }

    fun onLikeButtonClicked(id: Int) {
        if (!loading) {
            view?.toggleLikeButton(loading)
            loading = true
            launch {
                networkRequest(newsRepository.putLike(id)) {
                    onResponseSuccessful { }
                    onResponseFailed { _, _ -> }
                    onCallFailure { }
                }
                view?.toggleLikeButton(loading)
                loading = false
            }
        }
    }
}