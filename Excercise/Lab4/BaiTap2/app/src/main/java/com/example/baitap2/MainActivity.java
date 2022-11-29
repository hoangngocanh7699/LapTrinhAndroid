package com.example.baitap2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    PieChart pieChart;
    ArrayList barEntries;
    ArrayList pieEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart = findViewById(R.id.barchar);
        BarChar();

        pieChart = findViewById(R.id.piechar);
        PieChart();
    }

    private void PieChart() {
        getEntries();
        //data set
        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColor(Color.GREEN);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(18f);
        //dataset --> data
        PieData data = new PieData(pieDataSet);
        //data --> chart
        pieChart.setData(data);
    }

    private void BarChar() {
        getEntries();
        BarDataSet barDataset = new BarDataSet(barEntries, "");

        BarData barData = new BarData(barDataset);

        barChart.setData(barData);

        barDataset.setColor(Color.RED);
        barDataset.setValueTextColor(Color.WHITE);
        barDataset.setValueTextSize(18f);
    }

    private void getEntries() {
        barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1f, 1));
        barEntries.add(new BarEntry(2f, 2));
        barEntries.add(new BarEntry(3f, 3));
        barEntries.add(new BarEntry(4f, 4));
        barEntries.add(new BarEntry(5f, 5));
        barEntries.add(new BarEntry(6f, 6));

        pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(500, "2016"));
        pieEntries.add(new PieEntry(600, "2017"));
        pieEntries.add(new PieEntry(500, "2018"));
        pieEntries.add(new PieEntry(300, "2019"));
        pieEntries.add(new PieEntry(700, "2020"));
    }
}