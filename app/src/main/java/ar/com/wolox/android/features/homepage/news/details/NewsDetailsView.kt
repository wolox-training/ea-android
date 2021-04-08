package ar.com.wolox.android.features.homepage.news.details

interface NewsDetailsView {

    fun stopRefreshing()

    fun updateData(commenter: String, comment: String, isLikedByUser: Boolean)

    fun toggleLikeButton(state: Boolean)

    fun onResponseFailed()

    fun onCallFailed()
}