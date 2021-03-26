package ar.com.wolox.android.features.auth.login

import ar.com.wolox.android.example.network.builder.networkRequest
import ar.com.wolox.android.example.network.repository.UserRepository
import ar.com.wolox.android.utils.UserSession
import ar.com.wolox.android.extfunctions.isValidEmail
import ar.com.wolox.android.models.LoginBody
import ar.com.wolox.android.models.User
import ar.com.wolox.android.utils.Errors
import ar.com.wolox.wolmo.core.presenter.CoroutineBasePresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val userSession: UserSession,
    private val userRepository: UserRepository
) : CoroutineBasePresenter<LoginView>() {

    fun onLogInButtonClick(email: String, password: String) {

        val totalErrors: ArrayList<Errors> = ArrayList()

        if (email.isEmpty()) {
            totalErrors.add(Errors.EMPTY_EMAIL)
        } else if (!email.isValidEmail()) {
            totalErrors.add(Errors.INVALID_EMAIL)
        }

        if (password.isEmpty()) {
            totalErrors.add(Errors.EMPTY_PASSWORD)
        }
        for (actualError in totalErrors) {
            actualError.callAction(view!!)
        }
        if (totalErrors.isEmpty()) {
            validateLogin(LoginBody(email, password))
        }
    }

    fun onTermsAndConditionsTextClick() = view?.openBrowser(WOLOX_URL)

    fun onSignUpButtonClick() = view?.goToSignUp()

    private fun validateLogin(loginBody: LoginBody) {
        launch {
            networkRequest(userRepository.login(loginBody)) {
                onResponseSuccessful { response -> onValidLogin(response!!)
                    userSession.email = loginBody.email
                    userSession.password = loginBody.password }
                onResponseFailed { failedResponse, _ -> view?.showResponseError(failedResponse) }
                onCallFailure { view?.showCallError() }
            }
        }
    }

    private fun onValidLogin(user: User) {
        userSession.isOngoingSession = true
        // TODO store token, uid and client
        view?.goToHome()
    }

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
    }
}