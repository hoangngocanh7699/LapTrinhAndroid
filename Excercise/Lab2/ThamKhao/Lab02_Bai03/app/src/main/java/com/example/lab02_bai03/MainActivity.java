package com.example.lab02_bai03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<String> myPhrase = new ArrayList<String>();

    private Spinner spinner;
    private ListView listView;
    private GridView gridView;
    private TextView textView;

    private void init() {
        myPhrase.add("Android");
        myPhrase.add("iOS");
        myPhrase.add("Windows Phone");
        myPhrase.add("bOS");
        myPhrase.add("Blackberry");
        myPhrase.add("Symbian");

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listView);
        gridView = findViewById(R.id.gridView);
        textView = findViewById(R.id.textView);

        ArrayAdapter<String> arrayAdapterListView = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, myPhrase);
        ArrayAdapter<String> arrayAdapterSpinner = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, myPhrase);

        listView.setAdapter(arrayAdapterListView);
        spinner.setAdapter(arrayAdapterSpinner);
        gridView.setAdapter(arrayAdapterListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = myPhrase.get(position);
                textView.setText(selectedItem);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(myPhrase.get(position));
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(myPhrase.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
}