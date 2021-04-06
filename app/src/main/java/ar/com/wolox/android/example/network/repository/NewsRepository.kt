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

    suspend fun getNewsList(page: Int?) = withContext(Dispatchers.IO) {
        if (page != null) {
            NetworkRequestHandler.safeApiCall { services.getNewsPage(page) }
        } else {
            NetworkRequestHandler.safeApiCall { services.getFirstPage() }
        }
    }
}