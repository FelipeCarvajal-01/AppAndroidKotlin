package com.example.calculadora.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.R

class MainActivity : AppCompatActivity() {

    lateinit var frases: Button
    lateinit var calculadora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        frases = findViewById(R.id.button_quote)
        calculadora = findViewById(R.id.button_calculadora)

        buttonsSetOnClickListener()

    }
    private fun buttonsSetOnClickListener(){
        frases.setOnClickListener {
            startActivity( Intent(this, FrasesActivity::class.java))
        }
        calculadora.setOnClickListener {
            startActivity( Intent(this, CalculadoraActivity::class.java))
        }
    }
}