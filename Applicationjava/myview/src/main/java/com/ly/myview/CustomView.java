package com.ly.myview;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;


public class CustomView extends View {
    private static final String TAG = "CustomView";
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
//        this(context,attrs,R.style.style_defStyleAttr);
        this(context,attrs,R.attr.style_defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        this(context, attrs, 0,R.style.style_defStyleRes);
        this(context, attrs, 0,R.attr.style_defStyleRes);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.CustomView,defStyleAttr,defStyleRes);
        String t1 = ta.getString(R.styleable.CustomView_t1);
        String t2 = ta.getString(R.styleable.CustomView_t2);
        String t3 = ta.getString(R.styleable.CustomView_t3);
        String t4 = ta.getString(R.styleable.CustomView_t4);
        String t5 = ta.getString(R.styleable.CustomView_t5);
        Log.d(TAG, "t1: " + t1);
        Log.d(TAG, "t2: " + t2);
        Log.d(TAG, "t3: " + t3);
        Log.d(TAG, "t4: " + t4);
        Log.d(TAG, "t5: " + t5);
        ta.recycle();
    }
}
