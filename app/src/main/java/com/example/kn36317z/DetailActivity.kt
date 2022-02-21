package com.example.kn36317z

import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONArray

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Get clicked recipe data and use it.
        val productName = intent.getStringExtra("name")
        val products = JSONArray(intent.getStringExtra("products"))
        val instructions = intent.getStringExtra("instructions")

        findViewById<TextView>(R.id.recipeTitle).text = productName
        for (i in 0 until products.length())
        {
            val cb = CheckBox(this)
            cb.text = products.get(i).toString()
            cb.textSize = 20f
            findViewById<LinearLayout>(R.id.ingredientsList).addView(cb)
        }

        findViewById<TextView>(R.id.textHowTo).text = instructions
    }
}