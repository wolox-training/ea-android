package ar.com.wolox.android.root

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.login.utils.UserSession
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import javax.inject.Inject

class RootActivity @Inject constructor() : WolmoActivity<ActivityBaseBinding>() {
    @Inject var userSession: UserSession

    override fun layout() = R.layout.activity_base

    override fun init() {
        if (userSession.email.isNullOrEmpty() or userSession.password.isNullOrEmpty()) {
        //   val intent = Intent(this, LoginActivity()::class.java)
        //   startActivity(intent)
        } else {
            // lamar a una nueva actividad vacía
        }
    }
}