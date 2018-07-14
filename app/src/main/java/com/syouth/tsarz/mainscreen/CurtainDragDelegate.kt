package com.syouth.tsarz.mainscreen

import android.view.View
import android.widget.FrameLayout

private fun Float.truncateToRange(min: Float, max: Float) = when {
    this < min -> 0F
    this > max -> max
    else -> this
}

class CurtainDragDelegate(
        private val view: View, private val startY: Float, private val distance: Float) {

    fun update(newY: Float) = moveView(((newY - startY) / distance).truncateToRange(0F, 1F))

    private fun moveView(portion: Float) {
        with(view) {
            val lp = layoutParams as FrameLayout.LayoutParams
            val newPos = Math.cos(1.57 * portion - Math.PI / 2) * distance
            lp.topMargin = newPos.toInt()
            layoutParams = lp
        }
    }
}