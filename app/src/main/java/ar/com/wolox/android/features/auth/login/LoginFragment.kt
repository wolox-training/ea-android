package ar.com.wolox.android.features.auth.login

import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.LoginFragmentBinding
import ar.com.wolox.android.features.homepage.HomeActivity
import ar.com.wolox.android.features.auth.signup.SignupActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.openBrowser

class LoginFragment : WolmoFragment<LoginFragmentBinding, LoginPresenter>(), LoginView {

    override fun layout() = R.layout.login_fragment

    override fun init() {
    }

    override fun setListeners() {
        with(binding) {
            emailEditText.addTextChangedListener { presenter.onEmailInputChanged(it.toString()) }
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
            emailEditText.error = getString(R.string.empty_field_error)
        }
    }

    override fun showEmptyPasswordError() {
        with(binding) {
            passwordEditText.error = getString(R.string.empty_field_error)
        }
    }

    override fun showInvalidEmailError() {
        with(binding) {
            emailEditText.error = getString(R.string.invalid_email_error)
        }
    }

    override fun showResponseError() {
        Toast.makeText(requireContext(), getString(R.string.authentication_credential_error), Toast.LENGTH_SHORT).show()
    }

    override fun showCallError() {
        Toast.makeText(requireContext(), getString(R.string.connection_call_error), Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        with(binding) {
            simpleProgressBar.visibility = View.VISIBLE
        }
    }

    override fun hideProgressBar() {
        with(binding) {
            simpleProgressBar.visibility = View.INVISIBLE
        }
    }

    override fun loadEmail(email: String) {
        with(binding) {
                emailEditText.setText(email)
        }
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
