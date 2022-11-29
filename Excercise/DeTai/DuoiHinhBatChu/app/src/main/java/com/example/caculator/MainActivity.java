package com.example.caculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.caculator.API.LayCauHoi;
import com.example.caculator.Object.DATA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new LayCauHoi().execute();

        findViewById(R.id.btn_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DATA.getData().arrCauDo.size() > 0) {
                    startActivity(new Intent(getApplicationContext(), PlayGameActivity.class));
                } else {
                    Toast.makeText(MainActivity.this, "Chưa bật XAMPP hoặc chưa nhận được dữ liệu từ sever!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}