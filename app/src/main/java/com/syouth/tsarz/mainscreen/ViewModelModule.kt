package com.syouth.tsarz.mainscreen

import android.arch.lifecycle.ViewModel
import com.syouth.tsarz.application.ViewModelFactoryMapKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelFactoryMapKey(MainFragmentViewModel::class)
    abstract fun bindViewModel(viewModel: MainFragmentViewModel): ViewModel
}