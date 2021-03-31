package ar.com.wolox.android.features.root

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.utils.UserSession
import ar.com.wolox.android.features.homepage.HomeActivity
import ar.com.wolox.android.features.auth.login.LoginActivity
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
        if (userSession.email.isNullOrBlank() && userSession.password.isNullOrBlank()) {
            LoginActivity.start(this)
        } else {
            userSession.isOngoingSession = true
            HomeActivity.start(this)
        }
        this.finish()
    }
}