package com.example.baitap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<CustomListView> arrlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.ListView);
        arrlist = new ArrayList<CustomListView>();

        arrlist.add(new CustomListView(R.drawable.mercury,"Mercury","chi tiet ve Mercurychi tiet ve Mercurychi tiet ve Mercury"));
        arrlist.add(new CustomListView(R.drawable.venus,"Venus","chi tiet ve Mercurychi tiet ve Mercurychi tiet ve Mercury"));
        arrlist.add(new CustomListView(R.drawable.earth,"Earth","chi tiet ve Mercurychi tiet ve Mercury"));



        CustomLvAdapter adapter = new  CustomLvAdapter(this,R.layout.dong_item,arrlist);
        listView.setAdapter(adapter);
    }
}