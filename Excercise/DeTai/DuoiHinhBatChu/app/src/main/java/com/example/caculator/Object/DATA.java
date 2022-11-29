package com.example.caculator.Object;

import java.util.ArrayList;

public class DATA {

    private static DATA data;
    static {
        data = new DATA();
    }

    public  static DATA getData()
    {
        return  data;
    }
    //cac ham su dung chung
    public ArrayList<CauDo> arrCauDo = new ArrayList<>();
}
