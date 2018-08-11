package com.syouth.tsarz.cardview

import android.view.View
import android.widget.FrameLayout
import javax.inject.Inject

private fun Float.truncateToLowerBound(min: Float) = when {
    this < min -> 0F
    else -> this
}

private fun calculateNewPosition(fraction: Float, dst: Float) = (-Math.pow(Math.E, -4.3 * fraction) + 1) * dst
private fun calculateFraction(pos: Float, dst: Float) = Math.log((1F - (pos / dst)).toDouble()) / -4.3

@CardViewScope
class CurtainDragDelegate @Inject constructor(
        private val mView: View) {

    private var mStartGone = 0F
    private var mInitialPointerY = 0F
    private var mStartY = 0F
    private var mEndY = 0F
    private var mPointerDistanceTotal = 0F

    fun startDrag(initialPointerY: Float,
                  startY: Float,
                  endY: Float,
                  pointerDestinationTotal: Float) {
        mInitialPointerY = initialPointerY
        mStartY = startY
        mEndY = endY
        mPointerDistanceTotal = pointerDestinationTotal

        mView.clearAnimation()
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