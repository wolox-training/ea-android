package ar.com.wolox.android.features.homepage.viewpager

import androidx.fragment.app.Fragment
import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.HomeViewpagerFragmentBinding
import ar.com.wolox.android.features.homepage.news.NewsFragment
import ar.com.wolox.android.features.homepage.profile.ProfileFragment
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class HomeViewpagerFragment private constructor() : WolmoFragment<HomeViewpagerFragmentBinding, HomeViewpagerPresenter>(), HomeViewpagerView {

    @Inject
    internal lateinit var newsFragment: NewsFragment

    @Inject
    internal lateinit var profileFragment: ProfileFragment

    override fun layout() = R.layout.home_viewpager_fragment

    override fun init() {
        displayFragment(newsFragment)
    }

    override fun setListeners() {
        with(binding) {
            newsTab.setOnClickListener { presenter.onTabsClicked(newsFragment) }
            profileTab.setOnClickListener { presenter.onTabsClicked(profileFragment) }
        }
    }

    override fun displayFragment(fragment: Fragment) {
        with(binding) {
            requireActivity().supportFragmentManager.beginTransaction().add(displayFrame.id, fragment).commit()
        }
    }

    companion object {
        fun newInstance() = HomeViewpagerFragment()
    }
}