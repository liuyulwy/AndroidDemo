package com.ly.mylifecycle

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModelHandle(private val handle: SavedStateHandle): ViewModel() {
    private val key = "key"
    fun setValue(value: String) = handle.set(key, value)
    fun getValue(): LiveData<String> = handle.getLiveData(key)
    fun getValue1(){

        Log.d("MyViewModelHandle", "getValue1: " + handle.get<String>(key) + handle.get("query"))
    }

}
