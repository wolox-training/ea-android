package ar.com.wolox.android.features.auth.login

import ar.com.wolox.android.utils.UserSession
import ar.com.wolox.android.extfunctions.isValidEmail
import ar.com.wolox.android.utils.Errors
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    fun onLogInButtonClick(email: String, password: String) {

        val totalErrors: MutableList<Errors> = ArrayList()

        if (email.isEmpty()) {
            totalErrors.add(Errors.EMPTY_EMAIL)
        } else if (!email.isValidEmail()) {
            totalErrors.add(Errors.INVALID_EMAIL)
        }

        if (password.isEmpty()) {
            totalErrors.add(Errors.EMPTY_PASSWORD)
        }

        if (totalErrors.isEmpty()) {
            userSession.email = email
            userSession.password = password
            view?.goToHome()
        } else {
            for (actualError in totalErrors) {
                actualError.callAction(view!!)
            }
        }
    }

    fun onTermsAndConditionsTextClick() = view?.openBrowser(WOLOX_URL)

    fun onSignUpButtonClick() = view?.goToSignUp()

    companion object {

        private const val WOLOX_URL = "www.wolox.com.ar"
    }
}