package ar.com.wolox.android.models

data class News(
    var id: Int,
    var commenter: String,
    var comment: String,
    var date: String,
    var avatar: String,
    var likes: List<String>,
    var created_at: String,
    var updated_at: String
)
