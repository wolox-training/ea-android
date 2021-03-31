package ar.com.wolox.android.features.homepage.news

import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.models.News

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val viewTitle: TextView = view.findViewById(R.id.titleTextView)
    val viewDescription: TextView = view.findViewById(R.id.descriptionTextView)
    val viewLikeButton: RadioButton = view.findViewById(R.id.likeButton)
    val viewTime: TextView = view.findViewById(R.id.timeTextView)
    val viewImage: ImageView = view.findViewById(R.id.newsImageView)

    fun populate(dataSet: News) {
        with(dataSet) {
            viewTitle.text = title
            viewDescription.text = description
            viewLikeButton.isChecked = isLiked!!
            viewTime.text = postDate
            viewImage.contentDescription = image
        }
    }
}