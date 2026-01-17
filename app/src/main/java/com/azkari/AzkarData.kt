package com.azkari;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TasbeehActivity extends AppCompatActivity {

    TextView tvCount;
    Button btnAdd, btnReset;
    int count = 0;
    SharedPreferences prefs;
    boolean vibrateOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbeeh);

        tvCount = findViewById(R.id.tvCount);
        btnAdd = findViewById(R.id.btnAdd);
        btnReset = findViewById(R.id.btnReset);

        prefs = getSharedPreferences("settings", MODE_PRIVATE);
        vibrateOn = prefs.getBoolean("vibrate", true);

        count = prefs.getInt("count", 0);
        tvCount.setText(String.valueOf(count));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tvCount.setText(String.valueOf(count));
                prefs.edit().putInt("count", count).apply();

                if (vibrateOn) {
                    Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                    if (v != null) v.vibrate(30);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                tvCount.setText(String.valueOf(count));
                prefs.edit().putInt("count", count).apply();
            }
        });
    }
}
