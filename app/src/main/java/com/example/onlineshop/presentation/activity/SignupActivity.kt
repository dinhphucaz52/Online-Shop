package com.example.onlineshop.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onlineshop.R
import com.example.onlineshop.databinding.ActivitySignupBinding
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface

class SignupActivity : AppCompatActivity(), ActivityBaseInterface {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        setEvents()
    }

    override fun init() {
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
    }

    override fun setEvents() {
        binding.signUpButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (checkAccount(email, password)) {
                finish()
            }
        }
    }

    private fun checkAccount(email: String, password: String): Boolean {
        return true
    }
}