package ar.com.wolox.android.features.root

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class RootModule {
    @ContributesAndroidInjector
    internal abstract fun rootActivity(): RootActivity?
}