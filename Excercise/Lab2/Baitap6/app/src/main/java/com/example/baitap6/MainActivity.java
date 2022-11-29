package com.example.baitap6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    ImageButton btnplay;
    CheckBox cbOne, cbTwo,cbThere;
    SeekBar sbOne,sbTwo,sbThere;
    int SoDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        txtDiem.setText(SoDiem + "");

        sbOne.setEnabled(false);
        sbTwo.setEnabled(false);
        sbThere.setEnabled(false);

        CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            @Override
            public void onTick(long millisUntilFinished) {


                int number = 5;
                Random rd = new Random();
                int One = rd.nextInt(number);
                int two = rd.nextInt(number);
                int there = rd.nextInt(number);

                if (sbOne.getProgress() >= sbOne.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "One Win", Toast.LENGTH_SHORT).show();
                    btnplay.setVisibility(View.VISIBLE);
                    EnableCheckbox();
                    if (cbOne.isChecked()){
                        SoDiem += 10;
                        Toast.makeText(MainActivity.this, "Ban duoc cong 10 diem", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        SoDiem -=5;
                        Toast.makeText(MainActivity.this, "ban bi tru 5 diem", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem + "");
                }

                if (sbTwo.getProgress() >= sbTwo.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "Two Win", Toast.LENGTH_SHORT).show();
                    btnplay.setVisibility(View.VISIBLE);
                    EnableCheckbox();
                    if (cbTwo.isChecked()){
                        SoDiem += 10;
                        Toast.makeText(MainActivity.this, "Ban duoc cong 10 diem", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        SoDiem -=5;
                        Toast.makeText(MainActivity.this, "ban bi tru 5 diem", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem + "");
                }

                if (sbThere.getProgress() >= sbThere.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this, "There Win", Toast.LENGTH_SHORT).show();
                    btnplay.setVisibility(View.VISIBLE);
                    EnableCheckbox();
                    if (cbThere.isChecked()){
                        SoDiem += 10;
                        Toast.makeText(MainActivity.this, "Ban duoc cong 10 diem", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        SoDiem -=5;
                        Toast.makeText(MainActivity.this, "ban bi tru 5 diem", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(SoDiem + "");
                }

                sbOne.setProgress(sbOne.getProgress() + One);
                sbTwo.setProgress(sbTwo.getProgress() + two);
                sbThere.setProgress(sbThere.getProgress() + there );
            }

            @Override
            public void onFinish() {

            }
        };

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    cbTwo.setChecked(false);
                    cbThere.setChecked(false);
            }
        });

        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbOne.setChecked(false);
                cbThere.setChecked(false);
            }
        });

        cbThere.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cbTwo.setChecked(false);
                cbOne.setChecked(false);
            }
        });

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbOne.isChecked() || cbTwo.isChecked() || cbThere.isChecked()) {
                    btnplay.setVisibility(View.INVISIBLE);
                    sbOne.setProgress(0);
                    sbTwo.setProgress(0);
                    sbThere.setProgress(0);
                    countDownTimer.start();
                    DisableCheckBox();
                }
                else {
                    Toast.makeText(MainActivity.this, "Ban Phai Dat Cuoc", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void  EnableCheckbox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThere.setEnabled(true);
    }

    public void DisableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThere.setEnabled(false);
    }

    public  void AnhXa(){
        txtDiem     = findViewById(R.id.txtDiem);
        cbOne       = findViewById(R.id.checkboxOne);
        cbTwo       = findViewById(R.id.checkboxTwo);
        cbThere     = findViewById(R.id.checkboxThere);
        sbOne       = findViewById(R.id.seekbarOne);
        sbTwo       = findViewById(R.id.seekbarTwo);
        sbThere     = findViewById(R.id.seekbarThere);
        btnplay     = findViewById(R.id.btnPlay);
    }
}