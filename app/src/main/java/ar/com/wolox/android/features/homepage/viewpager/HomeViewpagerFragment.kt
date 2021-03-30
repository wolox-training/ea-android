package ar.com.wolox.android.features.homepage.viewpager

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
        setUpTabs()
    }

    private fun setUpTabs() {

        with(binding) {
            val adapter = ViewPagerAdapter(activity!!.supportFragmentManager).apply {
                addFragment(newsFragment)
                addFragment(profileFragment)
            }
            viewPager.adapter = adapter
            tabLayout.apply {
                tabLayout.setupWithViewPager(viewPager)
                getTabAt(0)!!.setIcon(R.drawable.news_tab_selector).text = context.getString(R.string.news_tab_text)
                getTabAt(1)!!.setIcon(R.drawable.profile_tab_selector).text = context.getString(R.string.profile_tab_text)
            }
        }
    }

    companion object {
        fun newInstance() = HomeViewpagerFragment()
    }
}