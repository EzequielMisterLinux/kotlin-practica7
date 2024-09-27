package com.alacrysoft.practica7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(
    private val countryList: List<Country>,
    private val onItemClicked: (Country) -> Unit
) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: ImageView = itemView.findViewById(R.id.flagImageView)
        val countryNameTextView: TextView = itemView.findViewById(R.id.countryNameTextView)

        fun bind(country: Country, onItemClicked: (Country) -> Unit) {
            flagImageView.setImageResource(country.flag)
            countryNameTextView.text = country.name
            itemView.setOnClickListener { onItemClicked(country) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList[position], onItemClicked)
    }

    override fun getItemCount(): Int = countryList.size
}
