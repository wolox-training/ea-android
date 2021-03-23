package ar.com.wolox.android.root

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.android.login.LoginActivity
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import javax.inject.Inject

class RootActivity : WolmoActivity<ActivityBaseBinding>() {

    @Inject
    lateinit var userSession: UserSession

    override fun layout() = R.layout.activity_base

    override fun init() {
        if (userSession.email.isNullOrEmpty() or userSession.password.isNullOrEmpty()) {
            LoginActivity.start(this)
        } else {
            // User is loged in, go to home activity
        }
    }
}