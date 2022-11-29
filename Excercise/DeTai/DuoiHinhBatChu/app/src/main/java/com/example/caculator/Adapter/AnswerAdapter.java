package com.example.caculator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.caculator.R;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends ArrayAdapter<String> {
    private Context myCt;
    private ArrayList<String> arr;

    public AnswerAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.myCt = context;
        this.arr = new ArrayList<>(objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) myCt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_answer, null);
        }
        TextView txtanswer = convertView.findViewById(R.id.txtanswer);
        txtanswer.setText(this.arr.get(position));
        return convertView;
    }
}
