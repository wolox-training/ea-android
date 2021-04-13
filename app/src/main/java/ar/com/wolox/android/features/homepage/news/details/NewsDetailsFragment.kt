package ar.com.wolox.android.features.homepage.news.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsDetailsFragmentBinding
import ar.com.wolox.android.extfunctions.deltaTime
import ar.com.wolox.android.models.NewFromPage
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.util.ToastFactory
import java.io.Serializable

class NewsDetailsFragment() : WolmoFragment<NewsDetailsFragmentBinding, NewsDetailsPresenter>(), NewsDetailsView {

    private var newsId: Int = 0

    override fun layout() = R.layout.news_details_fragment

    override fun init() {
        initializeData()
    }

    override fun setListeners() {
        with(binding) {
            newsSwipeRefresh.setOnRefreshListener { presenter.onSwipeRefresh(newsId) }
            likeRadioButton.setOnClickListener { presenter.onLikeButtonClicked(newsId) }
        }
    }

    override fun stopRefreshing() {
        binding.newsSwipeRefresh.isRefreshing = false
    }

    override fun updateData(commenter: String, comment: String, isLikedByUser: Boolean) {
        with(binding) {
            commenterTextView.text = commenter
            detailsDescriptionTextView.text = comment
            likeRadioButton.isChecked = isLikedByUser
        }
    }

    override fun toggleLikeButton(state: Boolean) {
        binding.likeRadioButton.isEnabled = state
    }

    override fun onCallFailed() {
        ToastFactory(requireContext()).show(getString(R.string.connection_call_error))
    }

    override fun onResponseFailed() {
        ToastFactory(requireContext()).show(getString(R.string.news_server_error))
    }

    override fun onLikeUpdateFailed() {
        ToastFactory(requireContext()).show(getString(R.string.like_update_failed))
    }

    private fun initializeData() {
        val newFromPage = arguments!!.getSerializable(DATA_SET) as NewFromPage
        val userId = arguments!!.getInt(USER_ID)
        newsId = newFromPage.id
        with(newFromPage) {
            setUpInitialData(commenter, comment, deltaTime(created_at), userId in likes)
        }
    }

    private fun setUpInitialData(commenter: String, comment: String, time: String, isLikedByUser: Boolean) {
        with(binding) {
            detailsTimeTextView.text = time
        }
        updateData(commenter, comment, isLikedByUser)
    }

    companion object {
        private const val DATA_SET = "data_Set"
        private const val USER_ID = "user_id"

        fun newInstance(dataSet: Serializable, userId: Int): Fragment = NewsDetailsFragment().apply {
            val bundle = Bundle().apply {
                putSerializable(DATA_SET, dataSet)
                putInt(USER_ID, userId)
            }
            arguments = bundle
        }
    }
}