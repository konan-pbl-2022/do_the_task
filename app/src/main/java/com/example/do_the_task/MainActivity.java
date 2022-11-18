package com.example.do_the_task;

//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final long START_TIME = 3600;

    private  TextView mTextViewCountDown;
    private  Button mButtonStartPause;
    private  Button getmButtonReset;
    private  TextView mTaskView;

    private  CountDownTimer mCountDownTimer;
    private  boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String inputStr = intent.getStringExtra("inputStr");
        System.out.println("mTimerRunningの初期値は？ " + mTimerRunning);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTaskView=findViewById(R.id.taskname);
        mTextViewCountDown = findViewById(R.id.textView);
        mButtonStartPause = findViewById(R.id.startButton);
        getmButtonReset = findViewById(R.id.resetButton);

        resetTimer();
        mTextViewCountDown.setText(String.valueOf(mTimeLeftInMillis));
        mTaskView.setText(inputStr);
        mButtonStartPause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.println("mTimerRunningの値は？ " +mTimerRunning);
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        getmButtonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("スタート");
                getmButtonReset.setVisibility(View.INVISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("一時停止");
        getmButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer(){
        System.out.println("一時停止処理前のmTimerRunningは？ " + mTimerRunning);
        mCountDownTimer.cancel();
        mTimerRunning = false;
        System.out.println("一時停止処理後のmTimerRunningは？ " + mTimerRunning);
        mButtonStartPause.setText("スタート");
        getmButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer(){
        Intent intent = getIntent();
        int minutes = intent.getIntExtra("minutes",0);
        mTimeLeftInMillis = START_TIME * minutes;
        updateCountDownText();
        mButtonStartPause.setVisibility(View.VISIBLE);
        getmButtonReset.setVisibility(View.INVISIBLE);
    }

    private void updateCountDownText(){
        int minutes = (int)(mTimeLeftInMillis/60)/60;
        int seconds = (int)(mTimeLeftInMillis/60)%60;
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timerLeftFormatted);
    }
}