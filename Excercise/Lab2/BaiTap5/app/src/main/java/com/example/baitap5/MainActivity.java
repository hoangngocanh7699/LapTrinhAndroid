package com.example.baitap5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gvhanhtinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvhanhtinh = findViewById(R.id.girdview);
        ArrayList<HanhTinh> arrlist = new ArrayList<HanhTinh>();

        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.earth));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.venus));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.sun));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.mercury));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.earth));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.venus));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.sun));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.mercury));
        arrlist.add(new HanhTinh("Tieu de","chi tiet",R.drawable.mercury));



        HanhTinhAdapter adapter = new HanhTinhAdapter(this,R.layout.hanh_tinh_layout,arrlist);
        gvhanhtinh.setAdapter(adapter);
    }
}