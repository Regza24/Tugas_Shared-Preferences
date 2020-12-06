package com.example.storage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()

        button.setOnClickListener {
            saveData()
        }
    }

    private fun saveData()
    {   val insertedText = et_text.text.toString()
        tv_text.text = insertedText

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY", insertedText)
        }.apply()

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadData()
    {   val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)

        tv_text.text = savedString
    }
}