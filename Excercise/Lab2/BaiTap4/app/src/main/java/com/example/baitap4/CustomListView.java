package com.example.baitap4;

import android.media.Image;
import android.widget.ImageView;

public class CustomListView {
    public Integer imghinh;
    public String Tieude;
    public String chitiet;

    public CustomListView(Integer imghinh, String tieude, String chitiet) {
        this.imghinh = imghinh;
        Tieude = tieude;
        this.chitiet = chitiet;
    }

    public Integer getImghinh() {
        return imghinh;
    }

    public void setImghinh(Integer imghinh) {
        this.imghinh = imghinh;
    }

    public String getTieude() {
        return Tieude;
    }

    public void setTieude(String tieude) {
        Tieude = tieude;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }
}
