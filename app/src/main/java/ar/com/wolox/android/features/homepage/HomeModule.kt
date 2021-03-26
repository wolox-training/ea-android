package ar.com.wolox.android.features.homepage

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {
    @ContributesAndroidInjector
    internal abstract fun homeActivity(): HomeActivity?
}