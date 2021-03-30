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
import kotlin.concurrent.timer

class RecyclerAdapter (private val dataSet: Array<News>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val title : TextView
        val description : TextView
        val likeButton : RadioButton
        val time : TextView
        val image : ImageView

        init {
            // Define click listener for the ViewHolder's View.
            description = view.findViewById(R.id.descriptionTextView)
            title = view.findViewById(R.id.titleTextView)
            likeButton = view.findViewById(R.id.likeButton)
            time = view.findViewById(R.id.timeTextView)
            image = view.findViewById(R.id.newsImageView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.news_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.title.text = dataSet[position].title
        viewHolder.description.text = dataSet[position].description
        viewHolder.likeButton.isPressed = dataSet[position].isLiked!!
        viewHolder.time.text = dataSet[position].title
        viewHolder.image.setImageDrawable(dataSet[position].image!!)
        //
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}