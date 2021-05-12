package com.ly.mylifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

interface IPresenter : LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart()
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate()
}