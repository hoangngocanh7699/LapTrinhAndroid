package com.example.caculator.Object;

import android.content.Context;
import android.content.SharedPreferences;

public class NguoiDung {
    private String nameData = "appDataXML2";
    public int tien;

    //Read XML File
    public void SaveTT(Context ct) {
        SharedPreferences settings = ct.getSharedPreferences(nameData, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("tien", tien);
        editor.commit();
    }

    public void GetTT(Context ct) {
        SharedPreferences settings = ct.getSharedPreferences(nameData, 0);
        tien = settings.getInt("tien", 20);
    }
}
