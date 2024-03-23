package com.example.praktikummodul2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import
        android.widget.CheckBox;
import
        android.widget.EditText;
import
        android.widget.RadioButton;
import
        android.widget.RadioGroup;
import
        android.widget.TextView;

public class MainActivity
        extends AppCompatActivity {
    int gajiStatus, gajiGolongan;
    RadioGroup golongan;
    CheckBox status;

    @Override
    public void onCreate(Bundle
                                 savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitung(View v) {
        EditText nama = (EditText) findViewById(R.id.nama);
        TextView outputNama = (TextView) findViewById(R.id.outputNama);
        String name = nama.getText().toString();
        outputNama.setText("Nama\t\t\t\t\t: " + name);

        status = (CheckBox) findViewById(R.id.menikah);
        String statusText = status.isChecked() ? "Status\t\t\t\t\t: Menikah" : "Status\t\t\t\t\t\t: Belum Menikah";

        golongan = (RadioGroup) findViewById(R.id.rgGolongan);
        int gol = golongan.getCheckedRadioButtonId();
        String golonganText = "";
        if (gol == R.id.rbGolongan1) {
            golonganText = "Golongan\t\t: 1";
        } else if (gol == R.id.rbGolongan2) {
            golonganText = "Golongan\t\t: 2";
        }

        gajiStatus = status.isChecked() ? 500000 : 0;
        gajiGolongan = gol == R.id.rbGolongan1 ? 1000000 : (gol == R.id.rbGolongan2 ? 2000000 : 0);

        int totalGaji = gajiStatus + gajiGolongan;
        TextView total = (TextView) findViewById(R.id.outputGaji);
        total.setText("Total Gaji\t\t: " + totalGaji);

        TextView statusView = (TextView) findViewById(R.id.outputStatus);
        statusView.setText(statusText);

        TextView golonganView = (TextView) findViewById(R.id.outputGolongan);
        golonganView.setText(golonganText);

        TextView hasilPerhitungan = (TextView) findViewById(R.id.hasilperhitungan);
        hasilPerhitungan.setText("HASIL PERHITUNGAN\n");
    }

}