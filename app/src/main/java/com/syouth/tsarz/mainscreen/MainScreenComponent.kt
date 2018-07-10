package com.syouth.tsarz.mainscreen

import dagger.Subcomponent

@Subcomponent
@MainScreenScope
interface MainScreenComponent {

    @Subcomponent.Builder
    interface Builder{
        fun build(): MainScreenComponent
    }
}