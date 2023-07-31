package com.example.trivia

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import com.example.trivia.databinding.ActivityMainBinding
import com.example.trivia.ui.main.MainFragment
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    // viewBinding
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView
        Log.i("MainActivity", "Se ejecuto la funcion onCreate")
        val buttonPlay: Button = findViewById(R.id.buttonPlay)
        buttonPlay.setOnClickListener {
            val intent = Intent(this, MainFragment::class.java).apply {
            }
            startActivity(intent)

        }
    }
}