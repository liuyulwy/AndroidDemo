package com.ly.application_java.ui.AlertDialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ly.application_java.R;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void buttonClick(View view) {

        AlertDialog alertDialog;
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

            case R.id.button5:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("message");
                builder.setPositiveButton("sure", (di, which) -> di.dismiss());
                TextView title = new TextView(this);
                title.setText("hello");
                title.setPadding(10, 10, 10, 10);
                title.setTextSize(18);
                title.setGravity(Gravity.CENTER);
                title.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                builder.setCustomTitle(title);
                alertDialog = builder.create();
                alertDialog.show();
                //必须在show()之后才能获取到button
                Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
                layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
                layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                layoutParams.gravity = Gravity.CENTER;

                button.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                button.setTextColor(getResources().getColor(android.R.color.white));
                button.setTextSize(16);
                button.setText("change");
                button.setLayoutParams(layoutParams);
                break;

            case R.id.button6:
                // 自定义弹窗
                builder = new AlertDialog.Builder(this);
                View alert_view = getLayoutInflater().inflate(R.layout.alert_custom,null,false);
                builder.setView(alert_view);//show 之前设置
                alertDialog = builder.create();
                alertDialog.show();
//                改变宽度
//                alertDialog.getWindow().setLayout(200,LinearLayout.LayoutParams.WRAP_CONTENT);

//                alertDialog = new AlertDialog.Builder(this)
//                        .setTitle("hhh")
//                        .setPositiveButton("sure", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        })
//                        .create();
//
//                alertDialog.show();
                //在show之后设置
//                alertDialog.setContentView(R.layout.alert_custom);
//                alertDialog.setContentView(alert_view);
                break;
        }

    }


}