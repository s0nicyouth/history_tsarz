package com.syouth.tsarz.base

import com.syouth.tsarz.navigation.NavigationManager
import dagger.BindsInstance
import dagger.Subcomponent

@TsarzActivityScope
@Subcomponent(modules = [TsarzActivityModule::class, ViewModelsModule::class])
interface TsarzActivityComponent {

    fun getNavigationManager(): NavigationManager

    fun getViewModelsFactory(): ViewModelsFactory

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: TsarzActivity): Builder

        fun build(): TsarzActivityComponent
    }
}