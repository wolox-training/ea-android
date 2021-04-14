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

        var notErrorFounds = true

        if (email.isEmpty()) {
            Errors.EMPTY_EMAIL.callAction(view!!)
            notErrorFounds = false
        } else if (password.isEmpty()) {
            Errors.EMPTY_PASSWORD.callAction(view!!)
            notErrorFounds = false
        } else if (!email.isValidEmail()) {
            Errors.INVALID_EMAIL.callAction(view!!)
            notErrorFounds = false
        }

        if (notErrorFounds) {
            validateLogin(LoginBody(email, password))
        }
    }

    fun onTermsAndConditionsTextClick() = view?.openBrowser(WOLOX_URL)

    fun onSignUpButtonClick() = view?.goToSignUp()

    fun onEmailInputChanged(email: String) {
        userSession.email = email
    }

    override fun onViewAttached() {
        super.onViewAttached()
        if (!userSession.email.isNullOrBlank()) {
            view?.loadEmail(userSession.email!!)
        }
    }

    private fun validateLogin(loginBody: LoginBody) {
        launch {
            view?.showProgressBar()
            networkRequest(userRepository.login(loginBody)) {
                onResponseSuccessful { response -> onValidLogin(response!!)
                    userSession.email = loginBody.email
                    userSession.password = loginBody.password }
                onResponseFailed { _, _ -> view?.showResponseError() }
                onCallFailure { view?.showCallError() }
            }
            view?.hideProgressBar()
        }
    }

    private fun onValidLogin(user: User) {
        userSession.isOngoingSession = true
        with(user.data) {
            userSession.let {
                it.id = id
                it.name = name
                it.nickname = nickname
                it.image = image
            }
        }
        view?.goToHome()
    }

    companion object {
        private const val WOLOX_URL = "www.wolox.com.ar"
    }
}