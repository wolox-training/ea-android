package ar.com.wolox.android.features.homepage.news

import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.models.NewFromPage

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val viewTitle: TextView = view.findViewById(R.id.titleTextView)
    val viewDescription: TextView = view.findViewById(R.id.descriptionTextView)
    val viewLikeButton: RadioButton = view.findViewById(R.id.likeButton)
    val viewTime: TextView = view.findViewById(R.id.timeTextView)
    val viewImage: ImageView = view.findViewById(R.id.newsImageView)

    fun populate(dataSet: NewFromPage?, clickListener: OnItemClickListener, userId: Int) {
        with(dataSet!!) {
            viewTitle.text = commenter
            viewDescription.text = comment
            viewTime.text = deltaTime(created_at)
            viewLikeButton.isChecked = userId in likes
        }
        itemView.setOnClickListener {
            clickListener.onItemClicked(dataSet, this.layoutPosition)
        }
    }
}