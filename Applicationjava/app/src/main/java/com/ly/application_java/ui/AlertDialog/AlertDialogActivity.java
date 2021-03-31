package com.ly.application_java.ui.AlertDialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ly.application_java.R;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void buttonClick(View view) {

        AlertDialog alertDialog = null;
        AlertDialog.Builder builder = null;
        int mId = view.getId();
        switch (mId) {
            case R.id.button:
                alertDialog = new AlertDialog.Builder(this)
                        .setTitle("提示")
                        .setMessage("message")
                        .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNeutralButton("mid", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();

                break;

            case R.id.button2:
                String[] items = new String[]{"one", "two", "three"};
                builder = new AlertDialog.Builder(this);
                alertDialog = builder.setTitle("提示")
                        .setIcon(R.mipmap.ic_launcher)
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).create();
                alertDialog.show();
                break;

            case R.id.button3:
                String[] items1 = new String[]{"one", "two", "three"};
                builder = new AlertDialog.Builder(this);
                alertDialog = builder.setTitle("提示")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(items1, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "你选择了" + items1[which], Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .create();
                alertDialog.show();
                break;

            case R.id.button4:
                String[] items2 = new String[]{"one", "two", "three"};
                boolean[] checkItems = new boolean[]{false, false, false};
                builder = new AlertDialog.Builder(this);
                alertDialog = builder.setTitle("提示")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMultiChoiceItems(items2, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkItems[which] = isChecked;
                            }
                        })
                        .setPositiveButton("sure", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
                break;
        }

    }


}