package com.syouth.tsarz.mainscreen

import android.view.View
import android.widget.FrameLayout

private fun Float.truncateToLowerBound(min: Float) = when {
    this < min -> 0F
    else -> this
}

private fun calculateNewPosition(fraction: Float, dst: Float) = (-Math.pow(Math.E, -4.3 * fraction) + 1) * dst
private fun calculateFraction(pos: Float, dst: Float) = Math.log((1F - (pos / dst)).toDouble()) / -4.3

class CurtainDragDelegate(
        private val mView: View,
        private val mInitialPointerY: Float,
        private val mStartY: Float,
        private val mEndY: Float,
        private val mPointerDistanceTotal: Float) {

    private val mStartGone: Float

    init {
        val lp = mView.layoutParams as FrameLayout.LayoutParams
        val fraction = calculateFraction(lp.topMargin - mStartY, mEndY - mStartY)
        mStartGone = (fraction * mPointerDistanceTotal).toFloat()
    }

    fun update(curY: Float)  = moveView(((mStartGone + curY - mInitialPointerY) / mPointerDistanceTotal).truncateToLowerBound(0F))

    private fun moveView(p: Float) = with(mView) {
        val lp = layoutParams as FrameLayout.LayoutParams
        lp.topMargin = (mStartY + calculateNewPosition(p, mEndY - mStartY)).toInt()
        layoutParams = lp
    }
}