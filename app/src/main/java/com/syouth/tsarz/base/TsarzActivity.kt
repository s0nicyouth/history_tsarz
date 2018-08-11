package com.syouth.tsarz.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.syouth.tsarz.R
import com.syouth.tsarz.application.ComponentsHolder

class TsarzActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tsarz)

        ComponentsHolder.initTsarzActivityComponent(this)
        ComponentsHolder.getTsarzComponent().getNavigationManager().openMainScreen()
    }
}
