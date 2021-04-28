package com.example.mytablayout;

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

    public void buttonClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_layout){
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
        }else if(id == R.id.tab_layout1){
            Intent intent = new Intent(this,MainActivity3.class);
            startActivity(intent);
        }else if(id == R.id.tab_layout2){
            Intent intent = new Intent(this,MainActivity4.class);
            startActivity(intent);
        }
    }
}