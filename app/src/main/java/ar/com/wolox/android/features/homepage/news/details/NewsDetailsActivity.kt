package ar.com.wolox.android.features.homepage.news.details

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsDetailsActivityBinding
import ar.com.wolox.android.models.NewFromPage
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class NewsDetailsActivity() : WolmoActivity<NewsDetailsActivityBinding>() {

    override fun layout() = R.layout.news_details_activity

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, NewsDetailsFragment.newInstance(intent.getSerializableExtra(DATA_SET)!!, intent.getIntExtra(USER_ID, 0)))
    }

    override fun setListeners() {
        with(binding) {
            topAppBar.setNavigationOnClickListener { this@NewsDetailsActivity.finish() }
        }
    }

    companion object {

        private const val DATA_SET = "data_set"
        private const val USER_ID = "user_id"

        fun start(context: Context, dataSet: NewFromPage, userId: Int, position: Int) {
            with(Intent(context, NewsDetailsActivity::class.java)) {
                putExtra(DATA_SET, dataSet)
                putExtra(USER_ID, userId)
                context.startActivity(this)
            }
        }
    }
}