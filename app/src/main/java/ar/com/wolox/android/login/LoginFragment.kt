package ar.com.wolox.android.login

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.LoginFragmentBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class LoginFragment : WolmoFragment<LoginFragmentBinding, LoginPresenter>(), LoginView {

    override fun layout() = R.layout.login_fragment

    override fun init() {
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}