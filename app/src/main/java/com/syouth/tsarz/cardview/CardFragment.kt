package com.syouth.tsarz.cardview

import android.arch.lifecycle.ViewModelProviders
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.syouth.tsarz.R
import com.syouth.tsarz.application.ComponentsHolder

class CardFragment : Fragment() {

    private lateinit var mViewModel: CardFragmentViewModel
    private lateinit var mCurtainDelegate: CurtainDragDelegate
    private lateinit var mCardViewComponent: CardViewComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        mViewModel = ViewModelProviders.of(
                this, ComponentsHolder.getTsarzComponent().getViewModelsFactory()).
                get(CardFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val inflatedView = inflater.inflate(R.layout.main_fragment, container, false)

        mCardViewComponent = ComponentsHolder.getTsarzComponent().getMainScreenComponent()
                .view(inflatedView.findViewById(R.id.title_image))
                .build()
        mCurtainDelegate = mCardViewComponent.getCurtainDragDelegate()

        inflatedView.findViewById<View>(R.id.title_image).setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mCurtainDelegate.startDrag(
                            event.rawY, -100F, 500F,
                            Resources.getSystem().displayMetrics.heightPixels.toFloat() / 2)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    mCurtainDelegate.update(event.rawY)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    animateBack(view, -100F)
                    true
                }
                else -> true
            }
        }

        return inflatedView
    }
}