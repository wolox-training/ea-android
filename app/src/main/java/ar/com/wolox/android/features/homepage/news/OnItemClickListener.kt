package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.models.News

abstract class OnItemClickListener {
    abstract fun onItemClicked(news: News)
}