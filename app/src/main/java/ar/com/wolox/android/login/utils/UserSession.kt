package ar.com.wolox.android.login.utils

import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.core.util.SharedPreferencesManager
import javax.inject.Inject

@ApplicationScope
class UserSession @Inject constructor(private val sharedPreferencesManager: SharedPreferencesManager) {

    var email: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLoginEmailPassword.EMAIL, null].also {
            field = it
        }
        set(email) {
            field = email
            sharedPreferencesManager.store(Extras.UserLoginEmailPassword.EMAIL, email)
        }

    var password: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLoginEmailPassword.PASSWORD, null].also {
            field = it
        }
        set(password) {
            field = password
            sharedPreferencesManager.store(Extras.UserLoginEmailPassword.PASSWORD, password)
        }
}