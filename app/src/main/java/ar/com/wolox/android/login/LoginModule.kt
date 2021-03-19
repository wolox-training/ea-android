package ar.com.wolox.android.login

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {
    @ContributesAndroidInjector
    abstract fun loginActivity(): LoginActivity?
    @ContributesAndroidInjector
    abstract fun loginFragment(): LoginFragment?
}