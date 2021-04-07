package ar.com.wolox.android.features.homepage.news.details

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewsDetailsModule {
    @ContributesAndroidInjector
    abstract fun newsDetailsActivity(): NewsDetailsActivity?
    @ContributesAndroidInjector
    abstract fun newsDetailsFragment(): NewsDetailsFragment?
}