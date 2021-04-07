package ar.com.wolox.android.features.homepage.news.details

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsDetailsActivityBinding
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class NewsDetailsActivity : WolmoActivity<NewsDetailsActivityBinding>() {

    override fun layout() = R.layout.news_details_activity

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, NewsDetailsFragment.newInstance())
    }

    companion object {
        fun start(context: Context) {
            with(Intent(context, NewsDetailsActivity::class.java)) {
                context.startActivity(this)
            }
        }
    }
}