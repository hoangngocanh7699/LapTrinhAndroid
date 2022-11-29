package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tvInputX;
    EditText tvInputY;
    TextView tvOutput;
    Button btnCong;
    Button btnTru;
    Button btnNhan;
    Button btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }
    protected void  Init(){
        tvInputX = findViewById(R.id.tvInputX);
        tvInputY = findViewById(R.id.tvInputY);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        tvOutput = findViewById(R.id.tvOuput);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double x = Double.parseDouble(tvInputX.getText().toString());
                Double y = Double.parseDouble(tvInputY.getText().toString());
                double  kq = x + y;

                tvOutput.setText(""  + kq);
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double x = Double.parseDouble(tvInputX.getText().toString());
                Double y = Double.parseDouble(tvInputY.getText().toString());
                double  kq = x - y;

                tvOutput.setText(""  + kq);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double x = Double.parseDouble(tvInputX.getText().toString());
                Double y = Double.parseDouble(tvInputY.getText().toString());
                double  kq = x * y;

                tvOutput.setText(""  + kq);
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double x = Double.parseDouble(tvInputX.getText().toString());
                Double y = Double.parseDouble(tvInputY.getText().toString());
                double  kq = x / y;

                tvOutput.setText(""  + kq);
            }
        });
    }
}