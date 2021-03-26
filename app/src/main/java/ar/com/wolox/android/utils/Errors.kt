package ar.com.wolox.android.utils

import ar.com.wolox.android.features.auth.login.LoginView

enum class Errors {
    EMPTY_PASSWORD {
        override fun callAction(view: LoginView?) { view?.showEmptyPasswordError() }
    },
    EMPTY_EMAIL {
        override fun callAction(view: LoginView?) { view?.showEmptyEmailError() }
    },
    INVALID_EMAIL {
        override fun callAction(view: LoginView?) { view?.showInvalidEmailError() }
    };
    abstract fun callAction(view: LoginView?)
}