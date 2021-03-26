package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.models.LoginBody
import ar.com.wolox.android.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/auth/sign_in")
    suspend fun login(@Body loginBody: LoginBody): Response<User>
}