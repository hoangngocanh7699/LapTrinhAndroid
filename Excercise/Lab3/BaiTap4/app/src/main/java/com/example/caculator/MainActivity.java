package com.example.caculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.Loader;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.Locale;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button  btnxacnhan;
    EditText edtTaiKhoan, edtMatKhau;
    TextView txttiengviet,txtenglish,txtfrance;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTaiKhoan.getText().toString();
                String matkhau = edtMatKhau.getText().toString();
                String text = getResources().getString(R.string.txtTaiKhoan)+ten+ "\n"+ getResources().getString(R.string.txtMatKhau)+matkhau;
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        txttiengviet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganNgonNgu("vi");
            }
        });
        txtenglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ganNgonNgu("en");
            }
        });
    }
    public void ganNgonNgu(String language){
        //gán ngôn ngữ
        Locale locale = new Locale(language);
        //cấu tạo lại hệ thống
        Configuration config = new Configuration();
        //Cấu hìn lại ngôn ngữ
        config.locale = locale;
        //cập nhật lại resource trong resource/string.xml
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        );
        //load lại View
        Intent intent = new Intent(MainActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public  void  AnhXa(){
        edtTaiKhoan = findViewById(R.id.txtusername);
        edtMatKhau = findViewById(R.id.txtpassrowd);
        btnxacnhan = findViewById(R.id.btnlogin);
        txttiengviet = findViewById(R.id.txttiengviet);
        txtenglish = findViewById(R.id.txtenglish);
        txtfrance = findViewById(R.id.txtfrance);
    }
}
