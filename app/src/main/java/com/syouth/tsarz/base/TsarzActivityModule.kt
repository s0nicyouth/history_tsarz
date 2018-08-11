package com.syouth.tsarz.base

import dagger.Module
import dagger.Provides

@Module
class TsarzActivityModule {

    @Provides
    @TsarzActivityScope
    fun provideFragmentManager(activity: TsarzActivity) = activity.supportFragmentManager


}