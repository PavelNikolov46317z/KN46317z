package com.example.kn36317z

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Get clicked button and send file that needs to get loaded.
    fun loadRecipes(view: View) {
        var fileToLoad = ""
        when (view.id) {
            R.id.salad -> { fileToLoad = "salad.json" }
            R.id.meat -> { fileToLoad = "meat.json" }
            R.id.vegan -> { fileToLoad = "vegan.json" }
            R.id.dessert -> { fileToLoad = "dessert.json" }
        }

        val intent = Intent(this, ListActivity::class.java).apply {
            putExtra("FileToLoad", fileToLoad)
        }

        startActivity(intent)
    }
}
