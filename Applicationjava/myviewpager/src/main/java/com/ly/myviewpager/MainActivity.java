package com.ly.myviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void itemClick(View view) {
        int id = view.getId();
        if (id == R.id.viewpager1){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }else if(id == R.id.viewpager2){
            Intent intent = new Intent(this, MainActivity3.class);
            startActivity(intent);
        }
    }
}