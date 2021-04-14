package ar.com.wolox.android.features.homepage.news

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import ar.com.wolox.android.models.NewFromPage

class RecyclerAdapter(private val context: Context, private val userId: Int) : RecyclerView.Adapter<NewsViewHolder>() {

    private var dataSet: MutableList<NewFromPage> = mutableListOf<NewFromPage>()
    private lateinit var itemClickListener: OnItemClickListener

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.news_row_item, viewGroup, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(newsViewHolder: NewsViewHolder, position: Int) {

        newsViewHolder.populate(dataSet[position], itemClickListener, userId)
    }

    override fun getItemCount() = dataSet.size

    fun setItemsListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    fun clearData() {
        dataSet.clear()
        this.notifyDataSetChanged()
    }

    fun addNews(nextNewFromPagePage: List<NewFromPage>) {
        dataSet.addAll(nextNewFromPagePage)
        dataSet.sortByDescending { newFromPage -> newFromPage.updated_at }
        this.notifyDataSetChanged()
    }
}