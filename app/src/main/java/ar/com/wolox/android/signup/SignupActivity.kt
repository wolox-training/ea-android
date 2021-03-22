package ar.com.wolox.android.signup

import android.content.Context
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.jumpTo

class SignupActivity : WolmoActivity<ActivityBaseBinding>() {

    override fun layout() = R.layout.activity_base

    override fun init() {
    }

    companion object {

        fun start(context: Context) = context.jumpTo(
            SignupActivity::class.java)
    }
}