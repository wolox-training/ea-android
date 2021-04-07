package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.models.News

interface OnItemClickListenerView {
    fun onItemClicked(news: News)
}