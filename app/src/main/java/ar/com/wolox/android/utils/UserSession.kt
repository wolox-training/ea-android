package ar.com.wolox.android.utils

import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.core.util.SharedPreferencesManager

import javax.inject.Inject

@ApplicationScope
class UserSession @Inject constructor(private val sharedPreferencesManager: SharedPreferencesManager) {

    // Really, we don't need to query the username because this instance live as long as the
    // application, but we should add a check in case Android decides to kill the application
    // and return to a state where this isn't initialized.

    var uid: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.UID, null].also {
            field = it
        }
        set(uid) {
            field = uid
            sharedPreferencesManager.store(Extras.UserLogin.UID, uid)
        }

    var client: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.CLIENT, null].also {
            field = it
        }
        set(client) {
            field = client
            sharedPreferencesManager.store(Extras.UserLogin.CLIENT, client)
        }

    var accessToken: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.ACCESS_TOKEN, null].also {
            field = it
        }
        set(accessToken) {
            field = accessToken
            sharedPreferencesManager.store(Extras.UserLogin.ACCESS_TOKEN, accessToken)
        }

    var isOngoingSession: Boolean = false
        set(isOngoingSession) {
            field = isOngoingSession
            sharedPreferencesManager.store(Extras.UserLogin.IS_ONGOING_SESSION, isOngoingSession)
        }

    var username: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.USERNAME, null].also {
            field = it
        }
        set(username) {
            field = username
            sharedPreferencesManager.store(Extras.UserLogin.USERNAME, username)
        }

    var email: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.EMAIL, null].also {
            field = it
        }
        set(email) {
            field = email
            sharedPreferencesManager.store(Extras.UserLogin.EMAIL, email)
        }

    var password: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.PASSWORD, null].also {
            field = it
        }
        set(password) {
            field = password
            sharedPreferencesManager.store(Extras.UserLogin.PASSWORD, password)
        }

    var id: Int = 0
        set(id) {
            field = id
            sharedPreferencesManager.store(Extras.UserLogin.ID, id)
        }

    var nickname: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.NICKNAME, null].also {
            field = it
        }
        set(nickname) {
            field = nickname
            sharedPreferencesManager.store(Extras.UserLogin.NICKNAME, nickname)
        }

    var image: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.IMAGE, null].also {
            field = it
        }
        set(image) {
            field = image
            sharedPreferencesManager.store(Extras.UserLogin.IMAGE, image)
        }

    var name: String? = null
        get() = field ?: sharedPreferencesManager[Extras.UserLogin.NAME, null].also {
            field = it
        }
        set(nickname) {
            field = name
            sharedPreferencesManager.store(Extras.UserLogin.NAME, name)
        }
}
