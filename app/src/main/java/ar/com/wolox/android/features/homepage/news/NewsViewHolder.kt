package ar.com.wolox.android.features.homepage.news

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.models.News
import com.bumptech.glide.Glide

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
            viewTime.text = date
            Glide.with(context).load(avatar).into(viewImage)
        }
    }
}