package com.example.doidonvidochieudai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Browser;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private  String[] units = {"Hải Lý", "Dặm", "Kilometer", "Lý", "Met", "Yard", "Foot", "Inches"};
    private  double[][] ratio = {
            {1.00000000, 1.15077945, 1.8520000, 20.2537183, 1852.0000, 2025.37183, 6076.11549, 72913.38583},
            {0.86897624, 1.00000000 ,1.6093440,17.6000000,1609.3440,1760.00000,5280.00000,63360.00000},
            {0.53995680,0.62137119,1.0000000,10.9361330,1000.0000,1093.61330,3280.83990,39370.07874},
            {0.04937365,0.05681818,0.0914400,1.0000000,91.4400,100.00000,300.00000,3600.00000},
            {0.00053996,0.00062137,0.0010000,0.0109361,1.0000,1.09361,3.28084,39.37008},
            {0.00049374,0.00056818,0.0009144,0.0100000,0.9144,1.00000,3.00000,36.00000},
            {0.00016458,0.00018939,0.0003048,0.0033333,0.3048,0.33333,1.00000,12.00000},
            {0.00001371,0.00001578,0.0000254,0.0002778,0.0254,0.02778,0.08333,1.00000}
    };
    private EditText txtInput;
    private Spinner spnUnits;
    private TextView[] lblresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput = (EditText) findViewById(R.id.txtInput);
        spnUnits = (Spinner) findViewById(R.id.spnUnits);
        lblresult = new TextView[]{
                (TextView)findViewById(R.id.lblHaily),
                (TextView)findViewById(R.id.lblDam),
                (TextView)findViewById(R.id.lblKm),
                (TextView)findViewById(R.id.lblLy),
                (TextView)findViewById(R.id.lblMet),
                (TextView)findViewById(R.id.lblYard),
                (TextView)findViewById(R.id.lblFoot),
                (TextView)findViewById(R.id.lblInches),
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,units);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        spnUnits.setAdapter(adapter);

        spnUnits.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ChangeUnits();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        txtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                ChangeUnits();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private void ChangeUnits(){
        int rowIdx = spnUnits.getSelectedItemPosition();

        if (rowIdx <0) rowIdx = 0;

        String input = txtInput.getText().toString();

        if (input.isEmpty())  input = "0";

        double number = Double.valueOf(input);

        for (int i = 0; i <lblresult.length;i++){
            double temp = number * ratio[rowIdx][i];
            lblresult[i].setText(String.valueOf(temp));
        }
    }
}