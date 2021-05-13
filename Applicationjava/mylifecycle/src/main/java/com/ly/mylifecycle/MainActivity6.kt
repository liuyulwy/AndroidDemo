package com.ly.mylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider

class MainActivity6 : AppCompatActivity() {

    private var searchManager = SearchManager(this)
    private lateinit var vm: MyViewModelHandle
    private lateinit var et: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        et = findViewById<EditText>(R.id.et)
        vm = ViewModelProvider(this).get(MyViewModelHandle::class.java)
        vm.getValue1()
    }

    fun btnClick(view: View) {
        vm.setValue(et.text.toString())
    }
}