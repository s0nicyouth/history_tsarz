package com.syouth.tsarz.cardsliderview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.syouth.tsarz.R
import com.syouth.tsarz.application.ComponentsHolder

class CardsPagerFragment : Fragment() {

    private lateinit var mViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        retainInstance = true
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val component = ComponentsHolder.getTsarzComponent().getCardsPagerComponent().build()
        val adapter = component.getPagerAdapter()

        val view =  inflater.inflate(R.layout.card_slider, container, false)
        mViewPager = view.findViewById(R.id.cards_pager)
        mViewPager.adapter = adapter
        return view
    }
}