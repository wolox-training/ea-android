package ar.com.wolox.android.features.homepage.news

import ar.com.wolox.android.models.NewFromPage

abstract class OnItemClickListener {
    abstract fun onItemClicked(newFromPage: NewFromPage)
}