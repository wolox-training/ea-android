package ar.com.wolox.android.features.homepage.viewpager

import androidx.fragment.app.Fragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class HomeViewpagerPresenter @Inject constructor() : BasePresenter<HomeViewpagerView>() {
    fun onTabsClicked(fragment: Fragment) {
        view?.displayFragment(fragment)
    }
    fun onProfileTabToggleFocus() {
    }
}