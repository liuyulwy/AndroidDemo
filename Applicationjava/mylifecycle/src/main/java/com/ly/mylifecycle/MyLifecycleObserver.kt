package com.ly.mylifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifecycleObserver : IPresenter {
    private val TAG = "MyLifecycleObserver"
    override fun onStart() {
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate: ")
    }


}