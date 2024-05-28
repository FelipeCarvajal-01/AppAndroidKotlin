package com.example.calculadora.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.R
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var frases: Button
    lateinit var calculadora: Button
    lateinit var sharedPrefs: Button
    private lateinit var tvUno: TextView
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Enlazar componentes con la vista por Id
        tvUno = findViewById(R.id.tvUno)

        tvUno.setText("Hola")
        tvUno.text = "Hola cracks!"

        frases = findViewById(R.id.button_quote)
        calculadora = findViewById(R.id.button_calculadora)
        sharedPrefs = findViewById(R.id.button_prefs)

        buttonsSetOnClickListener()

    }
    private fun buttonsSetOnClickListener(){
        frases.setOnClickListener {
            startActivity( Intent(this, FrasesActivity::class.java))
        }
        calculadora.setOnClickListener {
            startActivity( Intent(this, CalculadoraActivity::class.java))
        }
        sharedPrefs.setOnClickListener {
            startActivity( Intent(this, SharedPreferencesActivity::class.java))
        }
    }

}