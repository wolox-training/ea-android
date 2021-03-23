package ar.com.wolox.android.homepage

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ActivityBaseBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class HomeActivity : WolmoActivity<ActivityBaseBinding>() {

    override fun layout() = R.layout.home_activity

    override fun init() {
    }

    companion object {

        fun start(context: Context) {
            with(Intent(context, HomeActivity::class.java)) {
                context.startActivity(this)
            }
        }
    }
}