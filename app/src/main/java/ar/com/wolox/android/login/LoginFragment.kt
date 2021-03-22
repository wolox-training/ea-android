package ar.com.wolox.android.login

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.LoginFragmentBinding
import ar.com.wolox.android.homepage.HomeActivity
import ar.com.wolox.android.signup.SignupActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.openBrowser

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
    companion object {
        fun newInstance() = LoginFragment()
    }
}
