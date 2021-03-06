package com.syouth.tsarz.base

import com.syouth.tsarz.cardsliderview.CardsSliderComponent
import com.syouth.tsarz.cardview.CardViewComponent
import com.syouth.tsarz.navigation.NavigationManager
import dagger.BindsInstance
import dagger.Subcomponent

@TsarzActivityScope
@Subcomponent(modules = [TsarzActivityModule::class, ViewModelsModule::class])
interface TsarzActivityComponent {

    fun getNavigationManager(): NavigationManager

    fun getViewModelsFactory(): ViewModelsFactory

    fun getMainScreenComponent(): CardViewComponent.Builder

    fun getCardsPagerComponent(): CardsSliderComponent.Builder

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(activity: TsarzActivity): Builder

        fun build(): TsarzActivityComponent
    }
}