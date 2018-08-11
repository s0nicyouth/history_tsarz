package com.syouth.tsarz.navigation

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.syouth.tsarz.R
import com.syouth.tsarz.base.TsarzActivityScope
import com.syouth.tsarz.mainscreen.MainFragment
import javax.inject.Inject

@TsarzActivityScope
class NavigationManager @Inject constructor(fragmentManager: FragmentManager) {

    companion object {
        const val MAIN_FRAGMENT = "TAG_MAIN_FRAGMENT"
    }

    private val mFragmentManager = fragmentManager

    fun openMainScreen() {
        val fragment = MainFragment()
        addToBackStack(fragment, MAIN_FRAGMENT)
    }

    private fun addToBackStack(fragment: Fragment, tag: String) {
        mFragmentManager.beginTransaction()
                .replace(R.id.fragment_placeholder, fragment, tag)
                .addToBackStack(null)
                .commit()
    }
}