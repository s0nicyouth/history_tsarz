package com.syouth.tsarz.base

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@TsarzActivityScope
class ViewModelsFactory @Inject constructor(
        private val viewModelsMap: Map<Class<out ViewModel>,
                @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = viewModelsMap[modelClass]

        return creator?.get() as T
    }

}