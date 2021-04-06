package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.models.News

interface NewsView {

    fun stopRefreshing()

    fun updateNews(dataSet: List<News>)

    fun clearNewsFeed()

    fun showResponseError()

    fun showCallError()
}