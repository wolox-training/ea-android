package ar.com.wolox.android.features.homepage.news

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.models.News

class RecyclerAdapter(private val context: Context, private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<NewsViewHolder>() {

    private var dataSet: MutableList<News> = mutableListOf<News>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.news_row_item, viewGroup, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(newsViewHolder: NewsViewHolder, position: Int) {

        newsViewHolder.populate(dataSet[position], itemClickListener)
    }

    override fun getItemCount() = dataSet.size

    fun clearData() {
        dataSet.clear()
        this.notifyDataSetChanged()
    }

    fun addNews(nextNewsPage: List<News>) {
        dataSet.addAll(nextNewsPage)
        this.notifyDataSetChanged()
    }
}