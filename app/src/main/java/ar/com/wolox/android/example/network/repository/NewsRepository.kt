package ar.com.wolox.android.example.network.repository

import ar.com.wolox.android.example.network.services.NewsService
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.handler.NetworkRequestHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepository @Inject constructor (private val retrofitServices: RetrofitServices) {
    private val services: NewsService
        get() = retrofitServices.getService(NewsService::class.java)

    suspend fun getNewsList(page: Int = 1) = withContext(Dispatchers.IO) {
        NetworkRequestHandler.safeApiCall { services.getNewsPage(page) }
    }

    suspend fun getNewById(id: Int) = withContext(Dispatchers.IO) {
        NetworkRequestHandler.safeApiCall { services.getNewsById(id) }
    }

    suspend fun putLike(id: Int) = withContext(Dispatchers.IO) {
        NetworkRequestHandler.safeApiCall { services.putLike(id) }
    }
}