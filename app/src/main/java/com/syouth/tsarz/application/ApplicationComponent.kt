package com.syouth.tsarz.application

import android.content.Context
import com.syouth.tsarz.base.TsarzActivityComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationComponent {

    fun getTsarzComponent(): TsarzActivityComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }
}