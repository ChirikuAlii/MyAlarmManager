package com.example.chiriku711.myalarmmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnOneTimeDate , btnOneTimeTime , btnSetOneTime;
    TextView txtOneTimeDate , txtOneTimeTime;
    EditText edtOneTimeMessage;

    Button  btnRepeatingTime , btnSetRepeating , btnCancel;
    TextView  txtRepeatingTime;
    EditText edtRepeatingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOneTimeDate = findViewById(R.id.btn_one_time_date_alarm);
        btnOneTimeTime = findViewById(R.id.btn_one_time_time_alarm);

        btnSetOneTime = findViewById(R.id.btn_one_time_alarm);

        txtOneTimeDate = findViewById(R.id.txt_one_time_date_alarm);
        txtOneTimeTime = findViewById(R.id.txt_one_time_time_alarm);

        edtOneTimeMessage = findViewById(R.id.edt_one_time_alarm_message);
        edtRepeatingMessage =findViewById(R.id.edt_repeating_alarm_message);

        btnRepeatingTime = findViewById(R.id.btn_repeating_alarm_time);

        btnSetRepeating = findViewById(R.id.btn_repeating_alarm);

        txtRepeatingTime = findViewById(R.id.txt_repeating_alarm_time);

        btnCancel = findViewById(R.id.btn_cancel_repeating_alarm);


    }
}
