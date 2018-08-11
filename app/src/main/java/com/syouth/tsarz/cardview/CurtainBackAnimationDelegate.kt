package com.syouth.tsarz.cardview

import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.FrameLayout

fun animateBack(view: View, animateToY: Float) {
    val lp = view.layoutParams as FrameLayout.LayoutParams
    val startY = lp.topMargin
    val anim = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            val newY = ((1 - interpolatedTime) * startY + interpolatedTime * animateToY)
            with(view) {
                val lp = layoutParams as FrameLayout.LayoutParams
                lp.topMargin = newY.toInt()
                layoutParams = lp
            }
        }
    }

    anim.duration = 100
    view.startAnimation(anim)
}