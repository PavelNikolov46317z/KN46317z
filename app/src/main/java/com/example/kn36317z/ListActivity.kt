package com.example.kn36317z

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        val message = intent.getStringExtra("FileToLoad")
        if (message != null) {
            readJson(message)
        }
    }

    // Read the data from the json and created buttons.
    private fun readJson(name: String) {
        val json: String?

        try {
            val inputSystem: InputStream = assets.open(name)
            json = inputSystem.bufferedReader().use{it.readText()}
            val jsonArr = JSONArray(json)

            for (i in 0 until jsonArr.length())
            {
                val data = jsonArr.getJSONObject(i)
                val btn = Button(this)
                val id = data.getString("id").toInt()
                val productName = data.getString("name")
                val products = data.getJSONArray("products")
                val instructions = data.getString("instructions")
                btn.id = id
                btn.text = productName
                btn.textSize = 18f
                btn.setOnClickListener {
                    val intent = Intent(this, DetailActivity::class.java).apply {
                        putExtra("name", productName)
                        putExtra("products", products.toString())
                        putExtra("instructions", instructions)
                    }

                    startActivity(intent)
                }

                findViewById<LinearLayout>(R.id.recipesList).addView(btn)
            }

        } catch (e: IOException) {
            println(e)
        }
    }
}