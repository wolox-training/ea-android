package ar.com.wolox.android.features.auth.login

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {
    @ContributesAndroidInjector
    abstract fun loginActivity(): LoginActivity?
    @ContributesAndroidInjector
    abstract fun loginFragment(): LoginFragment?
}