package com.ly.mylifecycle

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData

class MyLiveData : LiveData<String>() {

    override fun onActive() {
        super.onActive()
        //添加监听
    }

    override fun onInactive() {
        super.onInactive()
        //移除监听
    }

}