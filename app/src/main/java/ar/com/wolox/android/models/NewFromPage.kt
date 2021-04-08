package ar.com.wolox.android.models

data class NewFromPage(
    val id: Int,
    val commenter: String,
    val comment: String,
    val date: String,
    val avatar: String,
    val likes: List<Int>,
    val created_at: String,
    val updated_at: String
)
