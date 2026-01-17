package com.azkari;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AzkarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<AzkarItem> azkarList;

    TextView tvCount;
    Button btnAdd, btnReset, btnSettings;
    int count = 0;
    SharedPreferences prefs;
    boolean vibrateOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar);

        // RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        azkarList = new ArrayList<>();
        loadAzkar();

        AzkarAdapter adapter = new AzkarAdapter(azkarList);
        recyclerView.setAdapter(adapter);

        // Tasbeeh
        tvCount = findViewById(R.id.tvCount);
        btnAdd = findViewById(R.id.btnAdd);
        btnReset = findViewById(R.id.btnReset);
        btnSettings = findViewById(R.id.btnSettings);

        prefs = getSharedPreferences("settings", MODE_PRIVATE);
        vibrateOn = prefs.getBoolean("vibrate", true);

        // حفظ العداد
        count = prefs.getInt("count", 0);
        tvCount.setText(String.valueOf(count));

        // تغيير الخلفية حسب الإعدادات
        int bg = prefs.getInt("background", 1);
        if (bg == 1) {
            findViewById(R.id.rootLayout).setBackgroundResource(R.drawable.bg1);
        } else if (bg == 2) {
            findViewById(R.id.rootLayout).setBackgroundResource(R.drawable.bg2);
        } else if (bg == 3) {
            findViewById(R.id.rootLayout).setBackgroundResource(R.drawable.bg3);
        }

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

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AzkarActivity.this, SettingsActivity.class));
            }
        });
    }

    private void loadAzkar() {
        // 30 ذكر صباحي
        azkarList.add(new AzkarItem("أذكار الصباح 1", "اللّهُ لا إِلَهَ إِلاّ هُوَ الْحَيُّ الْقَيُّومُ ... (3 مرات)"));
        azkarList.add(new AzkarItem("أذكار الصباح 2", "أَصْبَحْنا وَأَصْبَحَ المُلكُ لِلَّهِ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 3", "اللّهُمَّ بِكَ أَصْبَحْنا ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 4", "أَصْبَحَتْ أُمُورِي كُلُّهَا ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 5", "سُبْحانَ اللهِ وَبِحَمْدِهِ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 6", "اللَّهُمَّ أَنْتَ رَبِّي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 7", "اللَّهُمَّ إِنِّي أَسْأَلُكَ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 8", "اللَّهُمَّ إنِّي أَسْأَلُكَ العَفْوَ وَالعافِيَةَ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 9", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ مَا عَمِلْتُ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 10", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْكُفْرِ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 11", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الْجَنَّةَ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 12", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الهُدَى ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 13", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الرِّضَا ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 14", "اللَّهُمَّ إِنِّي أَسْأَلُكَ نَعِيمَ الدَّارِ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 15", "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ خَيْرِ مَا سَأَلَكَ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 16", "اللَّهُمَّ اجْعَلْنِي مِنَ الَّذِينَ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 17", "اللَّهُمَّ اغْفِرْ لِي ذَنْبِي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 18", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ فِتْنَةِ الْمَحْيَا ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 19", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ عَذَابِ القَبْر ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 20", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ سَمْعِي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 21", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ بَصَرِي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 22", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ لِسَانِي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 23", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ قَلْبِي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 24", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ عَمَلِي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 25", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ مَا أَعْلَمُ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 26", "اللَّهُمَّ إِنِّي أَسْأَلُكَ أَنْ تُبْعِدَ عَنِّي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 27", "اللَّهُمَّ إِنِّي أَسْأَلُكَ أَنْ تُسَلِّمَ لِي ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 28", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الْعَافِيَةَ فِي الدِّينِ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 29", "اللَّهُمَّ إِنِّي أَسْأَلُكَ العَفْوَ وَالعَافِيَةَ ..."));
        azkarList.add(new AzkarItem("أذكار الصباح 30", "اللَّهُمَّ أَصْبَحْتُ أُشْهِدُكَ ..."));

        // 30 ذكر مسائي
        azkarList.add(new AzkarItem("أذكار المساء 1", "اللّهُ لا إِلَهَ إِلاّ هُوَ الْحَيُّ الْقَيُّومُ ... (3 مرات)"));
        azkarList.add(new AzkarItem("أذكار المساء 2", "أَمْسَيْنا وَأَمْسَتِ المُلكُ لِلَّهِ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 3", "اللّهُمَّ بِكَ أَمْسَيْنا ..."));
        azkarList.add(new AzkarItem("أذكار المساء 4", "أَمْسَتْ أُمُورِي كُلُّهَا ..."));
        azkarList.add(new AzkarItem("أذكار المساء 5", "سُبْحانَ اللهِ وَبِحَمْدِهِ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 6", "اللَّهُمَّ أَنْتَ رَبِّي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 7", "اللَّهُمَّ إِنِّي أَسْأَلُكَ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 8", "اللَّهُمَّ إنِّي أَسْأَلُكَ العَفْوَ وَالعافِيَةَ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 9", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ مَا عَمِلْتُ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 10", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنَ الْكُفْرِ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 11", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الْجَنَّةَ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 12", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الهُدَى ..."));
        azkarList.add(new AzkarItem("أذكار المساء 13", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الرِّضَا ..."));
        azkarList.add(new AzkarItem("أذكار المساء 14", "اللَّهُمَّ إِنِّي أَسْأَلُكَ نَعِيمَ الدَّارِ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 15", "اللَّهُمَّ إِنِّي أَسْأَلُكَ مِنْ خَيْرِ مَا سَأَلَكَ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 16", "اللَّهُمَّ اجْعَلْنِي مِنَ الَّذِينَ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 17", "اللَّهُمَّ اغْفِرْ لِي ذَنْبِي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 18", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ فِتْنَةِ الْمَحْيَا ..."));
        azkarList.add(new AzkarItem("أذكار المساء 19", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ عَذَابِ القَبْر ..."));
        azkarList.add(new AzkarItem("أذكار المساء 20", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ سَمْعِي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 21", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ بَصَرِي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 22", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ لِسَانِي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 23", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ قَلْبِي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 24", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ عَمَلِي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 25", "اللَّهُمَّ إِنِّي أَعُوذُ بِكَ مِنْ شَرِّ مَا أَعْلَمُ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 26", "اللَّهُمَّ إِنِّي أَسْأَلُكَ أَنْ تُبْعِدَ عَنِّي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 27", "اللَّهُمَّ إِنِّي أَسْأَلُكَ أَنْ تُسَلِّمَ لِي ..."));
        azkarList.add(new AzkarItem("أذكار المساء 28", "اللَّهُمَّ إِنِّي أَسْأَلُكَ الْعَافِيَةَ فِي الدِّينِ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 29", "اللَّهُمَّ إِنِّي أَسْأَلُكَ العَفْوَ وَالعَافِيَةَ ..."));
        azkarList.add(new AzkarItem("أذكار المساء 30", "اللَّهُمَّ أَمْسَيْتُ أُشْهِدُكَ ..."));
    }
}
