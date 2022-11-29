package com.example.baitap4;

import android.content.Context;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomLvAdapter extends BaseAdapter {

    Context mycontext;
    int mylayout;
    List<CustomListView> arr;

    public CustomLvAdapter(Context context, int layout, List<CustomListView> list)
    {
        mycontext = context;
        mylayout = layout;
        arr  = list ;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mylayout,null);

        //anh xa va gan gia tri
        TextView txtTieude = (TextView) convertView.findViewById(R.id.textViewTieuDe);
        txtTieude.setText(arr.get(position).Tieude);

        TextView txtChiTiet = (TextView) convertView.findViewById(R.id.textViewChiTiet);
        txtChiTiet.setText(arr.get(position).chitiet);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(arr.get(position).imghinh);
        return convertView;
    }
}
