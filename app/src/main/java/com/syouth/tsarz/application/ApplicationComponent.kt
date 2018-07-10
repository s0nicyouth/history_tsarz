package com.syouth.tsarz.application

import com.syouth.tsarz.base.BaseComponent
import com.syouth.tsarz.mainscreen.ViewModelModule
import dagger.Component

@Component(modules = [ApplicationModule::class, ViewModelModule::class])
@ApplicationScope
interface ApplicationComponent {

    fun getBaseComponent(): BaseComponent.Builder

    fun getViewModelsFactory(): ViewModelsFactory

    @Component.Builder
    interface Builder {

        fun build() : ApplicationComponent
    }
}