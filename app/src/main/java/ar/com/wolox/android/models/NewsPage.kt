package ar.com.wolox.android.models

data class NewsPage(
    val count: Int,
    val current_page: Int,
    val next_page: Int?,
    val next_page_url: String?,
    val page: List<NewFromPage>,
    val previous_page: Int?,
    val previous_page_url: String?,
    val total_count: Int,
    val total_pages: Int
)
