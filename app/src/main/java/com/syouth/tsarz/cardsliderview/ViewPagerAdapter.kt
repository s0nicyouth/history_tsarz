package com.syouth.tsarz.cardsliderview

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.syouth.tsarz.cardview.CardFragment
import javax.inject.Inject

@CardsSliderScope
class ViewPagerAdapter @Inject constructor(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment = CardFragment()

    override fun getCount(): Int = 2

}