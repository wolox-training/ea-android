package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.models.NewFromPage

interface NewsView {

    fun stopRefreshing()

    fun updateNews(dataSet: List<NewFromPage>)

    fun clearNewsFeed()

    fun showResponseError()

    fun showCallError()

    fun goToNewsDetails(newFromPage: NewFromPage, userId: Int, position: Int)

    fun setUpRecycler(userId: Int)
}