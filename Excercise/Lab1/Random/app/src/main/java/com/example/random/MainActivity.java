package com.example.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnOK;
    TextView txtOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOK = findViewById(R.id.btnOK);
        txtOutput = findViewById(R.id.txtOutput);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                txtOutput.setText(number).;
                final Random rd = new Random();
                final int number = rd.nextInt(9); //tra ve mot so nguyen
                Toast.makeText(MainActivity.this, "So ngau nhien tu 1 den 10  la: "+ number, Toast.LENGTH_SHORT).show();
            }
        });
    }
}