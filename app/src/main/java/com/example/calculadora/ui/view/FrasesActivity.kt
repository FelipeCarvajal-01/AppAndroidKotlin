package com.example.calculadora.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.calculadora.databinding.ActivityFrasesBinding
import com.example.calculadora.ui.viewmodel.QuoteViewModel

class FrasesActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFrasesBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.OnCreate()

        binding.buttonHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }

}