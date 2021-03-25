package ar.com.wolox.android.features.auth.login

import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.LoginFragmentBinding
import ar.com.wolox.android.features.homepage.HomeActivity
import ar.com.wolox.android.features.auth.signup.SignupActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.openBrowser
import okhttp3.ResponseBody

class LoginFragment : WolmoFragment<LoginFragmentBinding, LoginPresenter>(), LoginView {

    override fun layout() = R.layout.login_fragment

    override fun init() {
    }

    override fun setListeners() {
        with(binding) {
            logInButton.setOnClickListener { presenter.onLogInButtonClick(emailEditText.text.toString(), passwordEditText.text.toString()) }
            signUpButton.setOnClickListener { presenter.onSignUpButtonClick() }
            termsAndConditionTextView.setOnClickListener { presenter.onTermsAndConditionsTextClick() }
        }
    }

    override fun openBrowser(url: String) = requireContext().openBrowser(url)

    override fun goToSignUp() = SignupActivity.start(requireContext())

    override fun goToHome() = HomeActivity.start(requireContext())

    override fun showEmptyEmailError() {
        with(binding) {
            emailEditText.error = getString(R.string.empty_email_error)
        }
    }

    override fun showEmptyPasswordError() {
        with(binding) {
            passwordEditText.error = getString(R.string.empty_password_error)
        }
    }

    override fun showInvalidEmailError() {
        with(binding) {
            emailEditText.error = getString(R.string.invalid_email_error)
        }
    }

    override fun showResponseError(failedResponse: ResponseBody?) {
        // failedResponse
        // implementar uso de los mensajes de error devueltos en el response body
        Toast.makeText(requireContext(), getString(R.string.authentication_credential_error), Toast.LENGTH_SHORT).show()
    }

    override fun showCallError() {
        Toast.makeText(requireContext(), getString(R.string.authentication_call_error), Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
