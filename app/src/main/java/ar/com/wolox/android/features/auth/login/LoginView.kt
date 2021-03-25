package ar.com.wolox.android.features.auth.login

import okhttp3.ResponseBody

interface LoginView {

    fun showEmptyPasswordError()

    fun showEmptyEmailError()

    fun showInvalidEmailError()

    fun showCallError()

    fun showResponseError(failedResponse: ResponseBody?)

    fun openBrowser(url: String)

    fun goToSignUp()

    fun goToHome()
}