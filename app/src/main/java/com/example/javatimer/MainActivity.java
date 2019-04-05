package com.example.javatimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView countcownText;
    private Button countownbutton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMs = 600000;
    private boolean timeRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countcownText = findViewById(R.id.countdown_text);
        countownbutton = findViewById(R.id.countdown_button);
        countownbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
    }

    public void startStop() {
        if (timeRunning) {
            stopTimer();
        } else {
            runTimer();
        }
    }

    public void stopTimer() {
        countDownTimer.cancel();
        timeRunning=false;
        countownbutton.setText("START");
    }



    public void runTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMs,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMs = l;
            updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        countownbutton.setText("PAUSE");
        timeRunning=true;
    }
public void updateTimer(){
        int minutes = (int)timeLeftInMs/60000;
        int seconds = (int) timeLeftInMs%60000 / 1000;
        String timeLeftText;
        timeLeftText=""+minutes;
        timeLeftText +=":";
        if (seconds<10)
            timeLeftText+="0";
        timeLeftText+=seconds;
        countcownText.setText(timeLeftText);
}

}
