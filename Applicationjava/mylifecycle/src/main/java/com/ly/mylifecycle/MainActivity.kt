package com.ly.mylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun btnClick(view: View) {
        val id = view.id
        if (id == R.id.button1){
            startActivity(Intent(this,MainActivity2::class.java))
        }else if(id == R.id.button2){
            startActivity(Intent(this,MainActivity3::class.java))
        }else if(id == R.id.button3){
            startActivity(Intent(this,MainActivity4::class.java))
        }else if(id == R.id.button4){
            startActivity(Intent(this,MainActivity5::class.java))
        }else if(id == R.id.button5){
            startActivity(Intent(this,MainActivity6::class.java))
        }
    }
}