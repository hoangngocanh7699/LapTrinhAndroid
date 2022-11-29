package com.example.caculator.Model;

import com.example.caculator.Object.CauDo;
import com.example.caculator.Object.DATA;
import com.example.caculator.Object.NguoiDung;
import com.example.caculator.PlayGameActivity;

import java.util.ArrayList;

public class ChoiGameModel {
    PlayGameActivity play;
    ArrayList<CauDo> arr;
    int cauSo = -1;
    public NguoiDung nguoiDung;

    public ChoiGameModel(PlayGameActivity play) {
        this.play = play;
        nguoiDung = new NguoiDung();
        taoData();
    }

    private void taoData() {
        arr = new ArrayList<>(DATA.getData().arrCauDo);
//        arr.add((new CauDo("Màn 3", "sauxa", "https://lazi.vn/uploads/dhbc/1470406880_sau-xa.jpg")));
//        arr.add((new CauDo("Màn 2", "nguao", "https://lazi.vn/uploads/dhbc/1466667821_ngua-o.jpg")));
//        arr.add((new CauDo("Màn 1", "baola", "https://4.bp.blogspot.com/-Trb-aq5diQA/U5E_MYEFXsI/AAAAAAAASyY/dYF-ljVBv7A/s1600/10431540_671362626263774_1717932326842688214_n.jpg")));
    }

    public CauDo layCauDo() {
        cauSo++;
        if (cauSo >= arr.size()) {
            cauSo = arr.size() - 1;
        }
        return arr.get(cauSo);
    }

    public void GetTT() {
        nguoiDung.GetTT(play);
    }

    public void SaveTT() {
        nguoiDung.SaveTT(play);
    }
}
