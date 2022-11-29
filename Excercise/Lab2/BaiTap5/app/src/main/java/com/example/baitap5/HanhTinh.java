package com.example.baitap5;

public class HanhTinh {
    public  String Tieude;
    public  String Chitiet;
    public  Integer imgsource;

    public HanhTinh(String tieude, String chitiet, Integer imgsource) {
        Tieude = tieude;
        Chitiet = chitiet;
        this.imgsource = imgsource;
    }

    public String getTieude() {
        return Tieude;
    }

    public void setTieude(String tieude) {
        Tieude = tieude;
    }

    public String getChitiet() {
        return Chitiet;
    }

    public void setChitiet(String chitiet) {
        Chitiet = chitiet;
    }

    public Integer getImgsource() {
        return imgsource;
    }

    public void setImgsource(Integer imgsource) {
        this.imgsource = imgsource;
    }
}
