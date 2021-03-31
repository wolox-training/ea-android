package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.models.News
import ar.com.wolox.android.models.NewsPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface NewsService {
    @GET("/comments")
    suspend fun getNewsList(): Response<NewsPage>
    @GET("/comments/{id}")
    suspend fun getNewsById(@Path("id") id: Int): Response<News>
    @PUT("/comments/like/{id}")
    suspend fun putLike(@Path("id") id: Int)
}