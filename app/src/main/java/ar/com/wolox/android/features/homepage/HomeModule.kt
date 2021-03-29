package ar.com.wolox.android.features.homepage

import ar.com.wolox.android.features.homepage.news.NewsFragment
import ar.com.wolox.android.features.homepage.profile.ProfileFragment
import ar.com.wolox.android.features.homepage.viewpager.HomeViewpagerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

    @ContributesAndroidInjector
    abstract fun homeActivity(): HomeActivity?
    @ContributesAndroidInjector
    abstract fun newsFragment(): NewsFragment?
    @ContributesAndroidInjector
    abstract fun profileFragment(): ProfileFragment?
    @ContributesAndroidInjector
    abstract fun homeViewpagerFragment(): HomeViewpagerFragment?
}