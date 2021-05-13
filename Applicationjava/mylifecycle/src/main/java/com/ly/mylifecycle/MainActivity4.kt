package com.ly.mylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity4 : AppCompatActivity() {
    val TAG = "MainActivity4"

    private lateinit var viewModel:MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        Log.d(TAG, "onCreate: " + viewModel.currentName.value)

        val nameObserver = Observer<String>{
            Log.d(TAG, "onCreate: $it")
        }
        //这里传入了this作为lifeowner(activity实现了lifeownerde ), 进入函数里面可以知道 创建了LifecycleBoundObserver来观察当前activity即传入的owner，
        //LifecycleBoundObserver 实现了 LifecycleEventObserver 来监听状态变化 当activity状态变化会通知到这个实现方法并改变活跃状态等。。。当数据发生变化时候，判断活跃状态来进行是否要进行通知observer
        //所以在activity处于非活跃状态时候是不会收到数据变化通知的
        viewModel.currentName.observe(this,nameObserver)

        val mapObserver = Observer<String> {
            Log.d(TAG, "onCreate: $it")
        }
        viewModel.mapLiveData.observe(this,mapObserver)

    }

    fun btnClick(view: View) {
        viewModel.currentName.value = "hell world"
    }
}