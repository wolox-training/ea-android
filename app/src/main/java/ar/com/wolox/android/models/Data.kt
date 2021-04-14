package ar.com.wolox.android.models

data class Data(
    val allow_password_change: Boolean,
    val email: String,
    val id: Int,
    val image: String?,
    val name: String,
    val nickname: String,
    val provider: String,
    val uid: String
)