package com.example.caculator;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.caculator.Adapter.AnswerAdapter;
import com.example.caculator.Model.ChoiGameModel;
import com.example.caculator.Object.CauDo;

import java.util.ArrayList;
import java.util.Random;


public class PlayGameActivity extends AppCompatActivity {

    ChoiGameModel models;
    CauDo cauDo;

    private String dapAn = "yeuot";

    ArrayList<String> arrAnswer;
    GridView dgvAnswer;

    ArrayList<String> arrDapAn;
    GridView dgvDapAn;

    int index = 0;
    ImageView imgAnhCauDo;
    TextView txtTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        Mapping();
        Innit();
        setOnclick();

        bamData();
        DisplayAnswer();
        DisPlayDapAn();
        hienCauDo();

    }

    private void Mapping() {
        dgvAnswer = findViewById(R.id.dgvanswer);
        dgvDapAn = findViewById(R.id.dgvdapan);
        imgAnhCauDo = (ImageView) findViewById(R.id.imganhcaudo);
        txtTien = findViewById(R.id.txttien);
    }

    private void Innit() {
        arrAnswer = new ArrayList<>();
        arrDapAn = new ArrayList<>();
        models = new ChoiGameModel(this);
    }

    public void hienCauDo() {
        cauDo = models.layCauDo();
        dapAn = cauDo.dapAn;

        Glide.with(this)
                .load(cauDo.anh)
                .into(imgAnhCauDo);
        models.GetTT();
        txtTien.setText(models.nguoiDung.tien + "");

        bamData();
        DisplayAnswer();
        DisPlayDapAn();
    }

    private void DisplayAnswer() {
        dgvAnswer.setNumColumns(6);
        if (arrAnswer.size() < 6) {
            dgvAnswer.setNumColumns(arrAnswer.size());
        }
        dgvAnswer.setAdapter(new AnswerAdapter(this, 0, arrAnswer));
    }

    private void DisPlayDapAn() {
        dgvDapAn.setNumColumns(6);
        if (arrDapAn.size() < 6) {
            dgvDapAn.setNumColumns(arrDapAn.size());
        }
        dgvDapAn.setAdapter(new AnswerAdapter(this, 0, arrDapAn));
    }

    private void setOnclick() {
        dgvDapAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);

                if (s.length() != 0 && index < arrAnswer.size()) {

                    for (int i = 0; i < arrAnswer.size(); i++) {
                        if (arrAnswer.get(i).length() == 0) {
                            index = i;
                            break;
                        }
                    }
                    arrDapAn.set(position, "");

                    arrAnswer.set(index, s);
                    index++;

                    DisplayAnswer();
                    DisPlayDapAn();
                    checkWin();
                }
            }
        });

        dgvAnswer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                if (s.length() != 0) {
                    index = position;
                    arrAnswer.set(position, "");
                    for (int i = 0; i < arrDapAn.size(); i++) {
                        if (arrDapAn.get(i).length() == 0) {
                            arrDapAn.set(i, s);
                            break;
                        }
                    }
                    DisplayAnswer();
                    DisPlayDapAn();
                }
            }
        });
    }

    //tách câu trả lời thành từng kí tự
    private void bamData() {
        index = 0;
        arrAnswer.clear();
        arrDapAn.clear();

        Random rd = new Random();
        for (int i = 0; i < dapAn.length(); i++) {
            arrAnswer.add("");
            String s = "" + (char) (rd.nextInt(26) + 65);
            arrDapAn.add(s);
            String s1 = "" + (char) (rd.nextInt(26) + 65);
            arrDapAn.add(s1);
        }

        //đem các kí tự của đáp án đặp vào arrDapAn
        for (int i = 0; i < dapAn.length(); i++) {
            String s = "" + dapAn.charAt(i);
            arrDapAn.set(i, s.toUpperCase());
        }

        for (int i = 0; i < arrDapAn.size(); i++) {
            String s = arrDapAn.get(i);

            //random vị trí của các kí tự
            int index = rd.nextInt(arrDapAn.size());
            arrDapAn.set(i, arrDapAn.get(index));
            arrDapAn.set(index, s);
        }
    }

    private void checkWin() {
        String s = "";
        for (String s1 : arrAnswer) {
            s = s + s1;
        }

        s = s.toUpperCase();
        if (s.equals(dapAn.toUpperCase())) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog_congratulations);
            dialog.show();
            final MediaPlayer player =  MediaPlayer.create(this,R.raw.congratulations);
            player.start();

            dialog.findViewById(R.id.btn_continue).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.hide();
                    player.stop();
                    models.GetTT();
                    models.nguoiDung.tien = models.nguoiDung.tien + 10;
                    models.SaveTT();
                    hienCauDo();

                }
            });
        }
    }


    //Mở gợi ý
    public void moGoiy(View view) {
        //KT người dùng còn tiền không
        models.GetTT();
        if (models.nguoiDung.tien < 5) {
            Toast.makeText(this, "Bạn không còn tiền để mở gợi ý", Toast.LENGTH_SHORT).show();
            return;
        }

        int index = -1;
        for (int i = 0; i < arrAnswer.size(); i++) {
            if (arrAnswer.get(i).length() == 0) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            //TH không còn chỗ sai, điền đủ rồi
            for (int i = 0; i < arrAnswer.size(); i++) {
                String s = dapAn.toUpperCase().charAt(i) + "";
                if (!arrAnswer.get(i).toUpperCase().equals(s)) {
                    index = i;
                    break;
                }
            }

            //TH người dùng điền sai điền lị cho đúng
            for (int i = 0; i < arrDapAn.size(); i++) {
                if (arrDapAn.get(i).length() == 0) {
                    arrDapAn.set(i, arrAnswer.get(index));
                    break;
                }
            }
        }
        String goiY = "" + dapAn.charAt(index);
        goiY = goiY.toUpperCase();
        for (int i = 0; i < arrAnswer.size(); i++) {
            if (arrAnswer.get(i).toUpperCase().equals(goiY)) {
                arrAnswer.set(i, "");
                break;
            }
        }

        for (int i = 0; i < arrDapAn.size(); i++) {
            if (goiY.equals(arrDapAn.get(i))) {
                arrDapAn.set(i, "");
                break;
            }
        }
        arrAnswer.set(index, goiY);
        checkWin();
        DisplayAnswer();
        DisPlayDapAn();

        //Trừ tiền
        models.GetTT();
        models.nguoiDung.tien = models.nguoiDung.tien - 5;
        models.SaveTT();
        txtTien.setText(models.nguoiDung.tien + "");

    }

    public void doiCauHoi(View view) {
        models.GetTT();
        if (models.nguoiDung.tien < 10) {
            Toast.makeText(this, "Bạn không còn tiền để đổi câu hỏi", Toast.LENGTH_SHORT).show();
            return;
        }
        models.nguoiDung.tien = models.nguoiDung.tien - 10;
        models.SaveTT();
        txtTien.setText(models.nguoiDung.tien + "");
        hienCauDo();
    }
}