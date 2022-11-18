package com.example.do_the_task;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class tourokuActivity extends AppCompatActivity {
    String inputStr;
    int minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touroku);

        //決定ボタンを押すと変数に格納
        Button nextButton = (Button)findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // 入力を受け取る
                @SuppressLint("WrongViewCast") EditText editText = (EditText)findViewById(R.id.editText);
                @SuppressLint("WrongViewCast") EditText minutesText = (EditText)findViewById(R.id.jikan);

                String minutesStr = minutesText.getText().toString();
                minutes = Integer.parseInt((minutesStr));

                inputStr = editText.getText().toString();

                TextView textView1 = (TextView)findViewById(R.id.textView);
                TextView textView2 = (TextView)findViewById(R.id.jikan);
                textView1.setText(inputStr);
                textView2.setText(String.valueOf(minutes));

                // 次の画面に遷移
                Intent intent = new Intent(getApplication(), MainActivity.class);
                intent.putExtra("inputStr",inputStr);
                intent.putExtra("minutes",minutes);
                startActivity(intent);
            }
        });

    }
}
