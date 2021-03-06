package ar.com.wolox.android.example.network.repository

import ar.com.wolox.android.example.network.services.LoginService
import ar.com.wolox.android.models.LoginBody
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.handler.NetworkRequestHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val retrofitServices: RetrofitServices) {

    private val service: LoginService
        get() = retrofitServices.getService(LoginService::class.java)

    suspend fun login(loginBody: LoginBody) = withContext(Dispatchers.IO) {
        NetworkRequestHandler.safeApiCall { service.login(loginBody) }
    }
}