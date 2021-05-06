package com.ly.myenvent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        int id = view.getId();
        if (id == R.id.button1){
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
        }
    }
}