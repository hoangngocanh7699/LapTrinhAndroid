package com.example.caculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    SeekBar skg;
    SeekBar skr;
    SeekBar skb;
    int g,r,b,c,m,y;
    TextView tvcolorGRB;
    TextView tvcolorTMY;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skg = findViewById(R.id.skg);
        skr = findViewById(R.id.skr);
        skb = findViewById(R.id.skb);
        tvcolorGRB = findViewById(R.id.tvcolorRGB);
        tvcolorTMY = findViewById(R.id.tvcolorTMY);



        skr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                r = progress;
                tvcolorGRB.setBackgroundColor(Color.rgb(r,g,b));

                c = 255-r;
                tvcolorTMY.setBackgroundColor(Color.rgb(c,m,y));


                tvcolorGRB.setText("Color RGB: ("+r+", "+g+", "+b+")");
                tvcolorTMY.setText("Color CMY: ("+c+", "+m+", "+y+")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                g = progress;
                tvcolorGRB.setBackgroundColor(Color.rgb(r,g,b));
                m = 255 - g;
                tvcolorTMY.setBackgroundColor(Color.rgb(c,m,y));

                tvcolorGRB.setText("Color RGB: ("+r+", "+g+", "+b+")");
                tvcolorTMY.setText("Color CMY: ("+c+", "+m+", "+y+")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b = progress;
                tvcolorGRB.setBackgroundColor(Color.rgb(r,g,b));
                y = 255 - b;
                tvcolorTMY.setBackgroundColor(Color.rgb(c,m,y));

                tvcolorGRB.setText("Color RGB: ("+r+", "+g+", "+b+")");
                tvcolorTMY.setText("Color CMY: ("+c+", "+m+", "+y+")");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

       // Color color =  Color.valueOf(r,g,b);
        //Log.d("AA","mau"+r);

    }
}
