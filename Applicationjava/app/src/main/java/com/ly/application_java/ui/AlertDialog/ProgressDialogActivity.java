package com.ly.application_java.ui.AlertDialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ly.application_java.R;

public class ProgressDialogActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void buttonClick(View view){
        int id = view.getId();
        if (id == R.id.button1){
            progressDialog = ProgressDialog.show(this,"title","message",false,true);
        }else if(id == R.id.button2){
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setTitle("title");
            progressDialog.setIcon(R.mipmap.ic_launcher);
            progressDialog.setMessage("message");
            progressDialog.setMax(100);
            progressDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            progressDialog.show();
            progressDialog.setProgress(50);
            progressDialog.setSecondaryProgress(70);
            progressDialog.setProgressNumberFormat("%2d");
            progressDialog.incrementProgressBy(2);
//            设置颜色
//            progressDialog.setProgressDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

            //不确定状态
//            progressDialog.setIndeterminate(true);

        }else if(id == R.id.button3){
            String result ="";
            Calendar cale1 = Calendar.getInstance();
            new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    //这里获取到的月份需要加上1哦~

                }
            }
                    ,cale1.get(Calendar.YEAR)
                    ,cale1.get(Calendar.MONTH)
                    ,cale1.get(Calendar.DAY_OF_MONTH)).show();

        }else if(id == R.id.button4){
            Calendar cale2 = Calendar.getInstance();
            new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                }
            }, cale2.get(Calendar.HOUR_OF_DAY), cale2.get(Calendar.MINUTE), true).show();
        }

    }
}