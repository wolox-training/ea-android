package ar.com.wolox.android.root

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.android.login.LoginActivity
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class RootActivity : WolmoActivity<ActivityBaseBinding>() {
//    @Inject
//    var userSession: UserSession

    override fun layout() = R.layout.activity_base

    override fun init() {
        LoginActivity.start(this)
    }
    /*@Inject var userSession: UserSession = SharedPreferences()

    override fun layout() = R.layout.activity_base

    override fun init() {
        if (userSession.email.isNullOrEmpty() or userSession.password.isNullOrEmpty()) {
        //   val intent = Intent(this, LoginActivity()::class.java)
        //   startActivity(intent)
        } else {
            // lamar a una nueva actividad vacía
        }
    }*/
}