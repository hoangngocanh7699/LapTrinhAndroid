package com.example.baitap3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DrawWithPath paintview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintview = findViewById(R.id.paintview);
        //clear
        findViewById(R.id.tbnclear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintview.clear = true;
                paintview.invalidate(); //goi lai onDraw
            }
        });
    }
}