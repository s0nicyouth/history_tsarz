package com.syouth.tsarz.application

object AppComponentHolder {
    private lateinit var sApplicationComponent: ApplicationComponent

    fun init() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .build()
    }

    fun get() = sApplicationComponent
}