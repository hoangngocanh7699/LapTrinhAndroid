package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private GridView gv;
    private Spinner spn;
    private TextView tview;
    private String[] listAndroid =  {"Android","iOS","WindowsPhone","bOS","BlackBerry","Symbian"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv_left);
        gv = (GridView) findViewById(R.id.gv_right) ;
        spn = (Spinner) findViewById(R.id.spinner);
        tview = (TextView) findViewById(R.id.textView);

        ArrayAdapter adapterlv = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listAndroid);
        lv.setAdapter(adapterlv);

        ArrayAdapter adaptergv = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listAndroid);
        gv.setAdapter(adaptergv);

        ArrayAdapter adapterspn = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listAndroid);
        spn.setAdapter(adapterspn);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tview.setText(listAndroid[position]);
            }
        });

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tview.setText(listAndroid[position]);
            }
        });

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tview.setText(listAndroid[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}