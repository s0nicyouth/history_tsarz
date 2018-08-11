package com.syouth.tsarz.application

import android.content.Context
import com.syouth.tsarz.base.TsarzActivity
import com.syouth.tsarz.base.TsarzActivityComponent

object ComponentsHolder {

    private lateinit var sApplicationComponent: ApplicationComponent

    private lateinit var sTsarzActivityComponent: TsarzActivityComponent

    fun initApplicationComponent(context: Context) {
        sApplicationComponent = DaggerApplicationComponent.builder().context(context).build()
    }

    fun getApplicationComponent() = sApplicationComponent

    fun initTsarzActivityComponent(tsarzActivity: TsarzActivity) {
        sTsarzActivityComponent =
                sApplicationComponent.getTsarzComponent().activity(tsarzActivity).build()
    }

    fun getTsarzComponent() = sTsarzActivityComponent
}