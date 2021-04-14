package ar.com.wolox.android.example.network.services

import ar.com.wolox.android.models.LikesResponse
import ar.com.wolox.android.models.NewFromDetails
import ar.com.wolox.android.models.NewsPage
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.PUT
import retrofit2.http.Query

interface NewsService {
    @GET("/comments")
    suspend fun getNewsPage(@Query("page")page: Int): Response<NewsPage>
    @GET("/comments/{id}")
    suspend fun getNewsById(@Path("id") id: Int): Response<NewFromDetails>
    @PUT("/comments/like/{id}")
    suspend fun putLike(@Path("id") id: Int): Response<LikesResponse>
}