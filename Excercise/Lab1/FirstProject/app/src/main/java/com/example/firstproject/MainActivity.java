package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnOK;
    EditText txtInput;
    TextView txtOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
    }
    private void initControl () {
        btnOK = findViewById(R.id.button);
        txtInput = findViewById(R.id.input);
        txtOutput = findViewById(R.id.output);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = txtInput.getText().toString();
                txtOutput.setText(str);
                Toast.makeText(MainActivity.this, "Hi " + str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
