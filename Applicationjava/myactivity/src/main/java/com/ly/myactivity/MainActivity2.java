package com.ly.myactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et = findViewById(R.id.et);
        Log.d(TAG, "onCreate: ");
        if (savedInstanceState != null){
            Log.d(TAG, "onCreate: " + savedInstanceState.getString("key"));
            Log.d(TAG, "onCreate: " + savedInstanceState.getString("text"));
            et.setText(savedInstanceState.getString("text"));
        }

    }

//    当你的手机异常关机，他能帮你找回之前前台的数据。他实际上是一种数据持久化的Activity  上面onCreate能找回内存中数据
//    需要在manifest中配置 android:persistableMode="persistAcrossReboots"
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        Log.d(TAG, "onCreate: 1");
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

//    如果自己没有配置android:ConfigChanges，这时默认让系统处理，就会重建Activity，此时Activity的生命周期会走一遍。
//    如果自己handle了，系统就不处理了，Activity不会重建，只会回调onConfigurationChanged方法。
//    如果不想横屏时activity自动重启, 可以在AndroidManifest文件的<activity>中声明android:configChanges="orientation|screenSize"属性, 当指定的系统配置发生改变的时候,
//    系统将不会重启activity, 而是执行程序中的public void onConfigurationChanged(Configuration newConfig)函数, 这样就可以让我们自己处理横屏这件事.

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(TAG, "onConfigurationChanged: ");
    }

//    @Override
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        Log.d(TAG, "onAttachedToWindow: ");
//    }
//
//    @Override
//    public void onDetachedFromWindow() {
//        super.onDetachedFromWindow();
//        Log.d(TAG, "onDetachedFromWindow: ");
//    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putString("key","value");
        outState.putString("text",et.getText().toString());
    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        Log.d(TAG, "onRestoreInstanceState: " + savedInstanceState.getString("key"));
        Log.d(TAG, "onRestoreInstanceState: " + savedInstanceState.getString("text"));
    }

//    @Override
//    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onRestoreInstanceState(savedInstanceState, persistentState);
//        Log.d(TAG, "onRestoreInstanceState: 1");
//    }
}