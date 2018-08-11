package com.syouth.tsarz.mainscreen

import dagger.Subcomponent

@MainScreenScope
@Subcomponent(modules = [MainScreenModule::class])
interface MainScreenComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): MainScreenComponent
    }
}