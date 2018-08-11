package com.syouth.tsarz.cardsliderview

import dagger.Subcomponent

@CardsSliderScope
@Subcomponent(modules = [CardsPagerModule::class])
interface CardsSliderComponent {

    fun getPagerAdapter(): ViewPagerAdapter

    @Subcomponent.Builder
    interface Builder {
        fun build(): CardsSliderComponent
    }
}