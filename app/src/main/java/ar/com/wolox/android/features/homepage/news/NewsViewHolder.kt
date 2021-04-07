package ar.com.wolox.android.features.homepage.news

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.models.News
import java.time.Instant
import java.time.temporal.ChronoUnit

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val viewTitle: TextView = view.findViewById(R.id.titleTextView)
    val viewDescription: TextView = view.findViewById(R.id.descriptionTextView)
    val viewLikeButton: RadioButton = view.findViewById(R.id.likeButton)
    val viewTime: TextView = view.findViewById(R.id.timeTextView)
    val viewImage: ImageView = view.findViewById(R.id.newsImageView)

    fun populate(dataSet: News?, context: Context) {
        with(dataSet!!) {
            viewTitle.text = commenter
            viewDescription.text = comment
            viewTime.text = deltaTime(updated_at)
        }
    }

    private fun deltaTime(lastUpdated: String): String {

        val currentTime = Instant.now()
        val lastUpdatedTime = Instant.parse(lastUpdated)

        return when (val period = ChronoUnit.MINUTES.between(lastUpdatedTime, currentTime)) {
            in 0..60 -> "${period}m"
            in 60..1440 -> "${period / 60}h"
            else -> "${period / 1440}d"
        }
    }
}