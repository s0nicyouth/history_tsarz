package com.syouth.tsarz.base

import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

@Module
class BaseModule {

    @Provides
    @BaseScope
    fun provideFragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
}