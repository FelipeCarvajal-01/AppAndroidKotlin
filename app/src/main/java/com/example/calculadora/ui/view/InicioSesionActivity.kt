package com.example.calculadora.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.camilo.calcu.data.dto.LoginDTO
import com.example.calculadora.R
import com.example.calculadora.data.utils.SharedApp
import com.example.calculadora.databinding.ActivityInicioSesionBinding
import com.example.calculadora.ui.viewmodel.LoginViewModel

class InicioSesionActivity : AppCompatActivity() {
    lateinit var binding:ActivityInicioSesionBinding
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityInicioSesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel.isLoading.observe(this, Observer{
            binding.progress.isVisible = it
        })

        loginViewModel.message.observe(this, Observer {
            if (it != null){
                showToastDialog(it)
            }
        })

        loginViewModel.userModel.observe(this, Observer {
            if (it != null){
                SharedApp.prefs.name = it.name.toString()
                SharedApp.prefs.jwt = it.jwt.toString()

                showQuotes()
            }
        })

        binding.btnlogin.setOnClickListener {
            val username:String = binding.etUser.text.toString()
            val password:String = binding.etPassword.text.toString()

            var loginDTO:LoginDTO = LoginDTO(username, password)
            loginViewModel.signIn(loginDTO)
            clearInputs()
        }
    }

    private fun showQuotes() {
        startActivity(Intent(binding.root.context, MainActivity::class.java))
        finish()
    }

    private fun clearInputs(){
        binding.etUser.setText("")
        binding.etPassword.setText("")
    }
    private fun showToastDialog(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}