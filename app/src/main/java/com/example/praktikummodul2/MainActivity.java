package com.example.praktikummodul2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.praktikummodul2.R;

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
        outputNama.setText("Total Gaji Anda " + name);
        status = (CheckBox) findViewById(R.id.menikah);
        if (status.isChecked()) {
            gajiStatus = 500000;
        } else {
            gajiStatus
                    = 0;
        }

        golongan = (RadioGroup) findViewById(R.id.rgGolongan);
        int gol =
                golongan.getCheckedRadioButtonId();
        if (gol == R.id.rbGolongan1) {
            gajiGolongan = 1000000;
        } else if (gol == R.id.rbGolongan2) {
            gajiGolongan =
                    2000000;
        }
        ;
        int totalGaji = gajiStatus + gajiGolongan;
        TextView total = (TextView) findViewById(R.id.outputGaji);
        total.setText(String.valueOf(totalGaji));
    }
}