package com.syouth.tsarz.base

import android.support.v7.app.AppCompatActivity
import com.syouth.tsarz.application.ViewModelsFactory
import com.syouth.tsarz.mainscreen.MainScreenComponent
import com.syouth.tsarz.mainscreen.ViewModelModule
import com.syouth.tsarz.navigation.NavigationManager
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [BaseModule::class])
@BaseScope
interface BaseComponent {

    fun getMainScreenComponent(): MainScreenComponent.Builder

    fun getNavigationManager(): NavigationManager

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: AppCompatActivity): Builder

        fun build(): BaseComponent
    }
}