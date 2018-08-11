package com.syouth.tsarz.base

import android.arch.lifecycle.ViewModel
import com.syouth.tsarz.cardsliderview.CardsPagerViewModel
import com.syouth.tsarz.cardview.CardFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelFactoryMapKey(CardFragmentViewModel::class)
    abstract fun bindMainFragmentViewModel(viewModel: CardFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelFactoryMapKey(CardsPagerViewModel::class)
    abstract fun bindCardsPagerViewModel(viewModel: CardsPagerViewModel): ViewModel
}