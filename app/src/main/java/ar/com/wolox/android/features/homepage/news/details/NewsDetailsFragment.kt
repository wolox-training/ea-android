package ar.com.wolox.android.features.homepage.news.details

import android.widget.Toast
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.NewsDetailsFragmentBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment

class NewsDetailsFragment(
    private val newsId: Int,
    private val commenter: String,
    private val comment: String,
    private val time: String,
    private val isLikedByUser: Boolean
) : WolmoFragment<NewsDetailsFragmentBinding, NewsDetailsPresenter>(), NewsDetailsView {

    override fun layout() = R.layout.news_details_fragment

    override fun init() {
        setUpInitialData(commenter, comment, time, isLikedByUser)
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
        Toast.makeText(requireContext(), getString(R.string.connection_call_error), Toast.LENGTH_SHORT)
    }

    override fun onResponseFailed() {
        Toast.makeText(requireContext(), getString(R.string.connection_call_error), Toast.LENGTH_SHORT)
    }

    override fun onLikeUpdateFailed() {
        Toast.makeText(requireContext(), getString(R.string.like_update_failed), Toast.LENGTH_SHORT)
    }

    private fun setUpInitialData(commenter: String, comment: String, time: String, isLikedByUser: Boolean) {
        with(binding) {
            detailsTimeTextView.text = time
        }
        updateData(commenter, comment, isLikedByUser)
    }

    companion object {
        fun newInstance(id: Int, commenter: String, comment: String, time: String, isLikedByUser: Boolean) = NewsDetailsFragment(id, commenter, comment, time, isLikedByUser)
    }
}