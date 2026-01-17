package com.azkari;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    Switch swVibrate;
    RadioButton rbBg1, rbBg2, rbBg3;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        swVibrate = findViewById(R.id.swVibrate);
        rbBg1 = findViewById(R.id.rbBg1);
        rbBg2 = findViewById(R.id.rbBg2);
        rbBg3 = findViewById(R.id.rbBg3);

        prefs = getSharedPreferences("settings", MODE_PRIVATE);

        // تحميل الإعدادات
        swVibrate.setChecked(prefs.getBoolean("vibrate", true));
        int bg = prefs.getInt("background", 1);

        if (bg == 1) rbBg1.setChecked(true);
        if (bg == 2) rbBg2.setChecked(true);
        if (bg == 3) rbBg3.setChecked(true);

        // حفظ الهزاز
        swVibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prefs.edit().putBoolean("vibrate", isChecked).apply();
            }
        });

        // حفظ الخلفية
        View.OnClickListener bgClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = 1;
                if (v.getId() == R.id.rbBg1) selected = 1;
                if (v.getId() == R.id.rbBg2) selected = 2;
                if (v.getId() == R.id.rbBg3) selected = 3;

                prefs.edit().putInt("background", selected).apply();
            }
        };

        rbBg1.setOnClickListener(bgClick);
        rbBg2.setOnClickListener(bgClick);
        rbBg3.setOnClickListener(bgClick);
    }
}
