package ar.com.wolox.android.features.auth.signup

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class SignupActivity : WolmoActivity<ActivityBaseBinding>() {

    override fun layout() = R.layout.sign_up_activity

    override fun init() {
    }

    companion object {
        fun start(context: Context) {
            with(Intent(context, SignupActivity::class.java)) {
                context.startActivity(this)
            }
        }
    }
}