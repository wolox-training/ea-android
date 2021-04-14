package ar.com.wolox.android.models

data class NewFromDetails(
    val avatar: String,
    val comment: String,
    val commenter: String,
    val date: String,
    val likes: List<Int>
)