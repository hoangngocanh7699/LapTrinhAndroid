package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button btnToast;
    Button btndialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnToast = findViewById(R.id.btntoast);
        btndialog = findViewById(R.id.btndialog);


        btndialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    ShowToast();
            }
        });

    }

    private void ShowDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.show();

        Button btnhuy = (Button) dialog.findViewById(R.id.btncancel);
        Button btnok = (Button) dialog.findViewById(R.id.btnok);
        final EditText edtusername = (EditText) dialog.findViewById(R.id.taikhoan);
        final EditText edtpassword = (EditText) dialog.findViewById(R.id.matkhau);

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Tai khoan: "+edtusername.getText()+", mat khau: "+edtpassword.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
    }

    private void ShowToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_root));

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.setGravity(Gravity.TOP|Gravity.LEFT, 200, 600);

        toast.show();
    }
}
