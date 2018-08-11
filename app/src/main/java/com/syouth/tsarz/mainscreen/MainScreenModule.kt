package com.syouth.tsarz.mainscreen

import android.arch.lifecycle.ViewModel
import com.syouth.tsarz.base.ViewModelFactoryMapKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainScreenModule {

    @Binds
    @IntoMap
    @ViewModelFactoryMapKey(MainFragmentViewModel::class)
    abstract fun provideViewModel(viewModel: MainFragmentViewModel): ViewModel
}