package ar.com.wolox.android.models

data class NewsPage(
    var page: List<News>,
    var count: Int,
    var total_pages: Int,
    var total_count: Int,
    var current_page: Int,
    var previous_page: Int?,
    var next_page: Int?,
    var next_page_url: String?,
    var previous_page_url: String?
)
