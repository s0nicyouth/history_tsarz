package com.syouth.tsarz.mainscreen

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

class MainFragment : Fragment() {

    private lateinit var mViewModel: MainFragmentViewModel
    private var mCurtainDelegate: CurtainDragDelegate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        mViewModel = ViewModelProviders.of(
                this, ComponentsHolder.getTsarzComponent().getViewModelsFactory()).
                get(MainFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val inflatedView = inflater.inflate(R.layout.main_fragment, container, false)

        inflatedView.findViewById<View>(R.id.title_image).setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    view.clearAnimation()
                    mCurtainDelegate = CurtainDragDelegate(
                            view,
                            event.rawY, -100F, 500F,
                            Resources.getSystem().displayMetrics.heightPixels.toFloat() / 2)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    mCurtainDelegate?.update(event.rawY)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    mCurtainDelegate = null
                    animateBack(view, -100F)
                    true
                }
                else -> true
            }
        }

        return inflatedView
    }
}