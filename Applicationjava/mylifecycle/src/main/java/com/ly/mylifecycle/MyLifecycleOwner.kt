package com.ly.mylifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class MyLifecycleOwner : LifecycleOwner {
    private var lifecycleRegistry : LifecycleRegistry = LifecycleRegistry(this)


    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    fun create(){
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    fun start(){
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }

    fun resume(){
        lifecycleRegistry.currentState = Lifecycle.State.RESUMED
    }
}