package com.example.beerapp
import kotlin.random.Random

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBeer = findViewById<Button>(R.id.btnBeer)
        val tvBeer = findViewById<TextView>(R.id.tvBeer)
        val spinBeer = findViewById<Spinner>(R.id.spinBeer)
        val recSort = findViewById<TextView>(R.id.recSort)
        val imageBeer = findViewById<ImageView>(R.id.imageBeer)

        val variety = arrayOf("Dark", "Light", "Rye", "Sweet", "Bitter")

        btnBeer.setOnClickListener {
            val type = spinBeer.selectedItem
            tvBeer.text = ("Your type beer: $type")

            if (type == "Dark") imageBeer.setImageResource(R.drawable.dark_beer)
            if (type == "Light") imageBeer.setImageResource(R.drawable.light_beer)
            if (type == "Rye") imageBeer.setImageResource(R.drawable.rye_beer)
            if (type == "Sweet") imageBeer.setImageResource(R.drawable.sweet_beer)
            if (type == "Bitter") imageBeer.setImageResource(R.drawable.bitter_beer)

            var identically = true
            var recBeer = ""
            while (identically == true) {
                recBeer = variety.random().toString()
                if (recBeer != type) identically = false
            }

            recSort.text = ("Recommend type: $recBeer")
        }
    }
}