package ar.com.wolox.android.features.homepage.news.details

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsDetailsActivityBinding
import ar.com.wolox.android.features.homepage.news.deltaTime
import ar.com.wolox.android.models.NewFromPage
import ar.com.wolox.wolmo.core.activity.WolmoActivity

class NewsDetailsActivity() : WolmoActivity<NewsDetailsActivityBinding>() {

    override fun layout() = R.layout.news_details_activity

    override fun init() {
        replaceFragment(binding.activityBaseContent.id, NewsDetailsFragment.newInstance(
            intent.getIntExtra(ID, 0),
            intent.getStringExtra(COMMENTER),
            intent.getStringExtra(COMMENT),
            deltaTime(intent.getStringExtra(UPDATED_AT)),
            intent.getBooleanExtra(LIKES, false)
        ))
    }

    override fun setListeners() {
        with(binding) {
            topAppBar.setNavigationOnClickListener { this@NewsDetailsActivity.finish() }
        }
    }

    companion object {

        private const val ID = "id"
        private const val COMMENTER = "commenter"
        private const val COMMENT = "comment"
        private const val AVATAR = "avatar"
        private const val UPDATED_AT = "updated_at"
        private const val LIKES = "likes"
        private const val USER_ID = "user_id"

        fun start(context: Context, dataSet: NewFromPage, userId: Int) {
            with(Intent(context, NewsDetailsActivity::class.java)) {
                with(dataSet) {
                    putExtra(ID, id)
                    putExtra(COMMENTER, commenter)
                    putExtra(COMMENT, comment)
                    putExtra(AVATAR, avatar)
                    putExtra(UPDATED_AT, updated_at)
                    putExtra(LIKES, userId in likes)
                    putExtra(USER_ID, userId)
                }
                context.startActivity(this)
            }
        }
    }
}