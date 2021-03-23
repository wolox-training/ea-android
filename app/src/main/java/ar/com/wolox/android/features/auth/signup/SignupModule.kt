package ar.com.wolox.android.features.auth.signup

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignupModule {
    @ContributesAndroidInjector
    internal abstract fun signupActivity(): SignupActivity?
}