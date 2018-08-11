package com.syouth.tsarz.cardview

import android.view.View
import dagger.BindsInstance
import dagger.Subcomponent

@CardViewScope
@Subcomponent(modules = [CardViewModule::class])
interface CardViewComponent {

    fun getCurtainDragDelegate(): CurtainDragDelegate

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun view(view: View): Builder

        fun build(): CardViewComponent
    }
}