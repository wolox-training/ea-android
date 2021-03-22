package ar.com.wolox.android.login

interface LoginView {

    fun showEmptyPasswordError()

    fun showEmptyEmailError()

    fun showInvalidEmailError()
}