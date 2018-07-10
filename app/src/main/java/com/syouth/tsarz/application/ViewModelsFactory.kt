package com.syouth.tsarz.application

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.syouth.tsarz.base.BaseScope
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@ApplicationScope
class ViewModelsFactory @Inject constructor(
        private val viewModelsMap: Map<Class<out ViewModel>,
                @JvmSuppressWildcards Provider<ViewModel>>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = viewModelsMap[modelClass]

        return creator?.get() as T
    }

}