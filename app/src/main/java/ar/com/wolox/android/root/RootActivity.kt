package ar.com.wolox.android.root

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.android.homepage.HomeActivity
import ar.com.wolox.android.login.LoginActivity
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import javax.inject.Inject

class RootActivity : WolmoActivity<ActivityBaseBinding>() {

    @Inject
    lateinit var userSession: UserSession

    override fun layout() = R.layout.activity_base

    override fun init() {
        validateUser()
    }

    private fun validateUser() {
        if (userSession.email.isNullOrEmpty() && userSession.password.isNullOrEmpty()) {
            LoginActivity.start(this)
        } else {
            HomeActivity.start(this)
        }
        this.finish()
    }
}