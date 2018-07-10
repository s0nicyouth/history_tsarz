package com.syouth.tsarz.mainscreen

import android.animation.ObjectAnimator
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.syouth.tsarz.R
import com.syouth.tsarz.application.AppComponentHolder
import com.syouth.tsarz.base.BaseComponentHolder

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

class MainFragment : Fragment() {

    private lateinit var mViewModel: MainFragmentViewModel
    private lateinit var mMainScreenComponent: MainScreenComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        mViewModel = ViewModelProviders.of(
                this, AppComponentHolder.get().getViewModelsFactory())
                .get(MainFragmentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mMainScreenComponent = BaseComponentHolder.get().getMainScreenComponent().build()

        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val anim = object: Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
                with (view.layoutParams as FrameLayout.LayoutParams) {
                    topMargin = (200.px - 200.px * interpolatedTime).toInt()
                    view.layoutParams = this
                }
            }
        }

        anim.duration = 2000
        view.startAnimation(anim)
        return view
    }
}