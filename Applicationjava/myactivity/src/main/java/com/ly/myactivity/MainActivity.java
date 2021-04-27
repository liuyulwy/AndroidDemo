package com.ly.myactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void btnClick(View view) {
        int id = view.getId();
        if (id == R.id.life_circle){
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
        }
    }
}