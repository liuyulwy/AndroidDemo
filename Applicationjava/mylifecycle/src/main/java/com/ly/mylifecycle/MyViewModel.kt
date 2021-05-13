package com.ly.mylifecycle

import android.view.animation.Transformation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    val currentName: MutableLiveData<String> by lazy{
        MutableLiveData()
    }
    val mapLiveData: LiveData<String> = Transformations.map(currentName){
        it + "map test"
    }

}