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
        if (userSession.isOngoingSession) {
            HomeActivity.start(this)
        } else {
            LoginActivity.start(this)
        }
        this.finish()
    }

    /*private fun headersInterceptor() = Interceptor { chain ->
        val request = chain.request().let {
            if (userSession.isOngoingSession) {
                it.newBuilder()
                    .addHeader(HEADER_ACCESS_TOKEN, userSession.accessToken!!)
                    .addHeader(HEADER_CLIENT, userSession.client!!)
                    .addHeader(HEADER_UID, userSession.uid!!)
                    .build()
            } else {
                it
            }
        }
        val response = chain.proceed(request)
        if (!response.header(HEADER_ACCESS_TOKEN).isNullOrEmpty()) {
            userSession.accessToken = response.header(HEADER_ACCESS_TOKEN)
        }
        if (!response.header(HEADER_CLIENT).isNullOrEmpty()) {
            userSession.client = response.header(HEADER_CLIENT)
        }
        if (!response.header(HEADER_UID).isNullOrEmpty()) {
            userSession.uid = response.header(HEADER_UID)
        }
        response
    } */
}