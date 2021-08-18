package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnStart, btnStop;
    TextView tv;
    long start,stop,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnstart);
        btnStop = (Button) findViewById(R.id.btnstop);
        tv = (TextView) findViewById(R.id.tvstopwatch);
        start = 0;
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start = System.currentTimeMillis();
                tv.setText("Stop Watch is started.");
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(start != 0){
                    stop = System.currentTimeMillis();
                    result = stop - start;
                    int milisec = (int) result;
                    int sec = milisec / 1000;
                    int min = sec /60;
                    int hour = min /60;
                    milisec %= 100;
                    sec %= 60;
                    min %= 60;
                    tv.setText(String.format("%02d:%02d:%02d:%02d",hour,min,sec,milisec));
                }

            }
        });


    }
}
