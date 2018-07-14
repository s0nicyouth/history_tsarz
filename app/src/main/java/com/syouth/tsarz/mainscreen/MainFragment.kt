package com.syouth.tsarz.mainscreen

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.OvershootInterpolator
import android.view.animation.Transformation
import android.widget.FrameLayout
import com.syouth.tsarz.R
import com.syouth.tsarz.application.AppComponentHolder
import com.syouth.tsarz.base.BaseComponentHolder

class MainFragment : Fragment() {

    private lateinit var mViewModel: MainFragmentViewModel
    private lateinit var mMainScreenComponent: MainScreenComponent
    private var mCurtainDelegate: CurtainDragDelegate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        mViewModel = ViewModelProviders.of(
                this, AppComponentHolder.get().getViewModelsFactory())
                .get(MainFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mMainScreenComponent = BaseComponentHolder.get().getMainScreenComponent().build()

        val inflatedView = inflater.inflate(R.layout.main_fragment, container, false)

        inflatedView.findViewById<View>(R.id.title_image).setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    mCurtainDelegate = CurtainDragDelegate(view, event.rawY, 250F)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    mCurtainDelegate?.update(event.rawY)
                    true
                }
                MotionEvent.ACTION_UP -> {
                    mCurtainDelegate = null
                    val anim = object : Animation() {
                        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                            with(view) {
                                val lp = layoutParams as FrameLayout.LayoutParams
                                lp.topMargin = (250F - 250F * interpolatedTime).toInt()
                                layoutParams = lp
                            }
                        }
                    }
                    anim.duration = 150
                    anim.interpolator = LinearOutSlowInInterpolator()
                    view.startAnimation(anim)
                    true
                }
                else -> true
            }
        }

        return inflatedView
    }
}