package ar.com.wolox.android.models

import android.graphics.drawable.Drawable
import java.util.*

data class News(var title: String?, var description: String?, var isLiked: Boolean?, var postDate: String?, val image: Drawable?)
