package com.example.chiriku711.myalarmmanager;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOneTimeDate , btnOneTimeTime , btnSetOneTime;
    TextView txtOneTimeDate , txtOneTimeTime;
    EditText edtOneTimeMessage;

    Button  btnRepeatingTime , btnSetRepeating , btnCancel;
    TextView  txtRepeatingTime;
    EditText edtRepeatingMessage;
    TimePickerDialog timePickerDialog;

    private Calendar calOneTimeDate , calOneTimeTime , calRepeatTimeTime;

    private AlarmReceiver alarmReceiver;
    private AlarmPreference alarmPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOneTimeDate = findViewById(R.id.btn_one_time_date_alarm);
        btnOneTimeDate.setOnClickListener(this);
        btnOneTimeTime = findViewById(R.id.btn_one_time_time_alarm);
        btnOneTimeTime.setOnClickListener(this);

        btnSetOneTime = findViewById(R.id.btn_one_time_alarm);
        btnSetOneTime.setOnClickListener(this);

        txtOneTimeDate = findViewById(R.id.txt_one_time_date_alarm);
        txtOneTimeTime = findViewById(R.id.txt_one_time_time_alarm);

        edtOneTimeMessage = findViewById(R.id.edt_one_time_alarm_message);
        edtRepeatingMessage =findViewById(R.id.edt_repeating_alarm_message);

        btnRepeatingTime = findViewById(R.id.btn_repeating_alarm_time);
        btnRepeatingTime.setOnClickListener(this);

        btnSetRepeating = findViewById(R.id.btn_repeating_alarm);
        btnSetRepeating.setOnClickListener(this);

        txtRepeatingTime = findViewById(R.id.txt_repeating_alarm_time);

        btnCancel = findViewById(R.id.btn_cancel_repeating_alarm);
        btnCancel.setOnClickListener(this);

        calOneTimeDate = Calendar.getInstance();
        calOneTimeTime = Calendar.getInstance();
        calRepeatTimeTime = Calendar.getInstance();

        alarmPreference = new AlarmPreference(this);
        alarmReceiver = new AlarmReceiver();



    }




    @Override
    public void onClick(View v) {

        if (v.getId()== R.id.btn_one_time_date_alarm){
            final Calendar currentDate = Calendar.getInstance();


            new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    calOneTimeDate.set(year, monthOfYear, dayOfMonth);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    txtOneTimeDate.setText(dateFormat.format(calOneTimeDate.getTime()));


                }
            }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();

            if (v.getId() == R.id.btn_one_time_time_alarm){
                final Calendar currentTime = Calendar.getInstance();

                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calOneTimeTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calOneTimeTime.set(Calendar.MINUTE,minute);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
                        txtOneTimeTime.setText(dateFormat.format(calOneTimeTime.getTime()));
                    }
                },currentTime.get(Calendar.HOUR_OF_DAY),currentTime.get(Calendar.MINUTE),true).show();
            }





        }
    }
}
