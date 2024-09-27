package com.alacrysoft.practica7

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val countryList = listOf(
        Country("Alemania", R.drawable.alemania),
        Country("Brazil", R.drawable.brazil),
        Country("Canada", R.drawable.canada),
        Country("El Salvador", R.drawable.elsalvador),
        Country("Francia", R.drawable.francia),
        Country("Japon", R.drawable.japon),
        Country("Rusia", R.drawable.rusia),
        Country("Spain", R.drawable.spain)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CountryAdapter(countryList) { country ->
            val intent = Intent(this, CountryDetailActivity::class.java)
            intent.putExtra("COUNTRY_NAME", country.name)
            intent.putExtra("COUNTRY_FLAG", country.flag)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}