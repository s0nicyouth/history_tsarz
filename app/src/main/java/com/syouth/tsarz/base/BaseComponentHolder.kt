package com.syouth.tsarz.base

import com.syouth.tsarz.application.AppComponentHolder

object BaseComponentHolder {
    private lateinit var sBaseComponent: BaseComponent

    fun init(activity: TsarzActivity) {
        sBaseComponent = AppComponentHolder.get().getBaseComponent()
                .activity(activity)
                .build()
    }

    fun get() = sBaseComponent
}