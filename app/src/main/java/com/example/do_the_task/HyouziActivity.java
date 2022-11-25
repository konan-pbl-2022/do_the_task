package com.example.do_the_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HyouziActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyouzi);
        Intent intent = getIntent();
        String name = intent.getStringExtra("kadai");
        Long time = intent.getLongExtra( "jikan", 0);

        //入力ボタン
        Button nextButton = (Button)findViewById(R.id.nyuryokubutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HyouziActivity.this,NyuryokuActivity.class);
                startActivity(intent);
//                data1 = intent.getIntExtra(MainActivity.Extra_Data,0);
            }
        });
    }
}