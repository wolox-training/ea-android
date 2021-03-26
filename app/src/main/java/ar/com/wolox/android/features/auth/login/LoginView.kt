package ar.com.wolox.android.features.auth.login

interface LoginView {

    fun showEmptyPasswordError()

    fun showEmptyEmailError()

    fun showInvalidEmailError()

    fun showCallError()

    fun showResponseError()

    fun showProgressBar()

    fun hideProgressBar()

    fun loadEmail(email: String)

    fun openBrowser(url: String)

    fun goToSignUp()

    fun goToHome()
}