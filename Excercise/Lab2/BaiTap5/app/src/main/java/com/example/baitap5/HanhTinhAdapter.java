package com.example.baitap5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class HanhTinhAdapter extends BaseAdapter {

    Context mycontext;
    int mylayout;
    List<HanhTinh> arrlist;

    public HanhTinhAdapter (Context context, int layout, List<HanhTinh> hanhTinhList){
        mycontext = context;
        mylayout = layout;
        arrlist = hanhTinhList;
    }

    @Override
    public int getCount() {
        return arrlist.size();
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
        txtTieude.setText(arrlist.get(position).Tieude);

        TextView txtChiTiet = (TextView) convertView.findViewById(R.id.textViewChiTiet);
        txtChiTiet.setText(arrlist.get(position).Chitiet);

        ImageView imageView = convertView.findViewById(R.id.imageViewHanhTinh);
        imageView.setImageResource(arrlist.get(position).imgsource);
        return convertView;
    }
}
