package ar.com.wolox.android.login

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.android.login.utils.Errors
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(private val userSession: UserSession) : BasePresenter<LoginView>() {

    private fun isEmailValid(email: String): Boolean {
        val parts = email.split("@")
        if (parts.size != 2) {
            return false
        }
        if (parts[0].isEmpty()) {
            return false
        }
        val domain = parts[1].split(".")
        if (domain.size < 2) {
            return false
        }
        return true
    }

    fun onLogInButtonClick(email: String, password: String) {

        val totalErrors: MutableList<Errors> = ArrayList()

        if (email.isEmpty()) totalErrors.add(Errors.EMPTY_EMAIL)

        else if (!isEmailValid(email)) totalErrors.add(Errors.INVALID_EMAIL)

        if (password.isEmpty()) totalErrors.add(Errors.EMPTY_PASSWORD)

        if (totalErrors.isEmpty()) {
            userSession.email = email
            userSession.password = password
        } else {
            for (actualError in totalErrors) {
                actualError.callAction(view!!)
            }
        }
    }
}