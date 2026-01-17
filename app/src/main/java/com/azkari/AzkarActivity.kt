package com.azkari

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AzkarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_azkar)

        val recyclerView = findViewById<RecyclerView>(R.id.azkarRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AzkarAdapter(AzkarData.getMorningAzkar())
    }
}
