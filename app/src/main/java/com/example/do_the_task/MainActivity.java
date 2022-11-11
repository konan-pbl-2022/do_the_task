package com.example.do_the_task;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button okButton = (Button)findViewById(R.id.button);
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                @SuppressLint("WrongViewCast") EditText editText = (EditText)findViewById(R.id.editText);
                String inputStr = editText.getText().toString();
                TextView textView1 = (TextView)findViewById(R.id.textView);
                textView1.setText(inputStr);
            }
        });

    }
}