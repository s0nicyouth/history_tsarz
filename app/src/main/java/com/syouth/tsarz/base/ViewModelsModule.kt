package com.syouth.tsarz.base

import android.arch.lifecycle.ViewModel
import com.syouth.tsarz.mainscreen.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelFactoryMapKey(MainFragmentViewModel::class)
    abstract fun bindMainFragmentViewModel(viewModel: MainFragmentViewModel): ViewModel
}