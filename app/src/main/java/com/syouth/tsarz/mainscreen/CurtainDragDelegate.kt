package com.syouth.tsarz.mainscreen

import android.util.Log
import android.view.View
import android.widget.FrameLayout

private fun Float.truncateToRange(min: Float, max: Float) = when {
    this < min -> 0F
    this > max -> max
    else -> this
}

private fun calculateNewPosition(fraction: Float, dst: Float) = Math.cos(1.57 * fraction - Math.PI / 2) * dst
private fun calculateFraction(pos: Float, dst: Float) = (-Math.acos((pos / dst).toDouble()) + Math.PI / 2) / 1.57

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

    fun update(curY: Float)  = moveView(((mStartGone + curY - mInitialPointerY) / mPointerDistanceTotal).truncateToRange(0F, 1F))

    private fun moveView(p: Float) = with(mView) {
        val lp = layoutParams as FrameLayout.LayoutParams
        Log.d("Tsarz", p.toString())
        lp.topMargin = (mStartY + calculateNewPosition(p, mEndY - mStartY)).toInt()
        layoutParams = lp
    }
}