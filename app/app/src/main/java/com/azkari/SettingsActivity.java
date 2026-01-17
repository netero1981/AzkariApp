package com.azkari;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    Switch swVibrate;
    Button btnBg1, btnBg2, btnQibla;
    TextView tvDate;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        swVibrate = findViewById(R.id.swVibrate);
        btnBg1 = findViewById(R.id.btnBg1);
        btnBg2 = findViewById(R.id.btnBg2);
        btnQibla = findViewById(R.id.btnQibla);
        tvDate = findViewById(R.id.tvDate);

        prefs = getSharedPreferences("settings", MODE_PRIVATE);

        // تفعيل/تعطيل الهزاز
        swVibrate.setChecked(prefs.getBoolean("vibrate", true));
        swVibrate.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefs.edit().putBoolean("vibrate", isChecked).apply();
        });

        // تغيير الخلفية
        btnBg1.setOnClickListener(v -> {
            prefs.edit().putInt("bg", 1).apply();
            finish();
        });

        btnBg2.setOnClickListener(v -> {
            prefs.edit().putInt("bg", 2).apply();
            finish();
        });

        // زر القبلة (بدون GPS)
        btnQibla.setOnClickListener(v -> {
            tvDate.setText("اتجاه القبلة ثابت (مقترح) - يمكنك إضافة خريطة لاحقاً");
        });

        // التاريخ الميلادي + الهجري
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
        String date = sdf.format(cal.getTime());
        tvDate.setText("التاريخ الميلادي: " + date + "\nالتاريخ الهجري: (قريباً)");
    }
}
