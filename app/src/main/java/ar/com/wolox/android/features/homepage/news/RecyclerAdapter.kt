package ar.com.wolox.android.features.homepage.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.models.News

class RecyclerAdapter(private val dataSet: Array<News>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.titleTextView)
        val description: TextView = view.findViewById(R.id.descriptionTextView)
        val likeButton: RadioButton = view.findViewById(R.id.likeButton)
        val time: TextView = view.findViewById(R.id.timeTextView)
        val image: ImageView = view.findViewById(R.id.newsImageView)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.news_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.title.text = dataSet[position].title
        viewHolder.description.text = dataSet[position].description
        viewHolder.likeButton.isChecked = dataSet[position].isLiked!!
        viewHolder.time.text = dataSet[position].postDate
        viewHolder.image.setImageDrawable(dataSet[position].image!!)
    }

    override fun getItemCount() = dataSet.size
}