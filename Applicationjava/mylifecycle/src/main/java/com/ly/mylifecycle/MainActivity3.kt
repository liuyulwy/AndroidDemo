package com.ly.mylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity() {
    private lateinit var myLifecycleOwner: MyLifecycleOwner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        //自定义lifecycle owner 添加监听器
        myLifecycleOwner = MyLifecycleOwner()
        myLifecycleOwner.lifecycle.addObserver(MyLifecycleObserver())
        //改变状态
        myLifecycleOwner.create()
    }

    override fun onStart() {
        super.onStart()
        myLifecycleOwner.start()
    }

    override fun onResume() {
        super.onResume()
        myLifecycleOwner.resume()
    }
}