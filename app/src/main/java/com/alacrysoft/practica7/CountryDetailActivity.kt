package com.alacrysoft.practica7

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_county_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val countryName = intent.getStringExtra("COUNTRY_NAME")
        val countryFlag = intent.getIntExtra("COUNTRY_FLAG", 0)

        val countryNameTextView: TextView = findViewById(R.id.countryNameTextView)
        val countryFlagImageView: ImageView = findViewById(R.id.countryFlagImageView)

        countryNameTextView.text = countryName
        countryFlagImageView.setImageResource(countryFlag)
    }
}
