package ar.com.wolox.android.login

interface LoginView {

    fun showEmptyPasswordError()

    fun showEmptyEmailError()

    fun showInvalidEmailError()

    fun openBrowser(url: String)

    fun goToSignUp()

    fun goToHome()
}