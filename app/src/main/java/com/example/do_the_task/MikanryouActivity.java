package com.example.do_the_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MikanryouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mikanryou);
        //表示画面に戻る
        Button nextButton = (Button)findViewById(R.id.button4);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MikanryouActivity.this, HyouziActivity.class);
                startActivity(intent);
            }
        });
    }
}