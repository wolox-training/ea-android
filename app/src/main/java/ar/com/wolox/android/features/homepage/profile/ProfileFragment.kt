package ar.com.wolox.android.features.homepage.profile

import ar.com.wolox.android.R
import ar.com.wolox.android.databinding.ProfileFragmentBinding
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class ProfileFragment @Inject constructor() : WolmoFragment<ProfileFragmentBinding, ProfilePresenter>(), ProfileView {

    override fun layout() = R.layout.profile_fragment

    override fun init() {
    }
    companion object {
        fun newInstance() = ProfileFragment()
    }
}