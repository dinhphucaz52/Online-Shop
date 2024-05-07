package com.example.onlineshop.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.databinding.ActivityLoginBinding
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface

class LoginActivity : AppCompatActivity(), ActivityBaseInterface {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
        setEvents()
    }

    override fun init() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
    }

    override fun setEvents() {
        binding.apply {
            loginButton.setOnClickListener {
                val email = binding.emailEditText.text.toString()
                val password = binding.passwordEditText.text.toString()
                if (findAccount(email, password)) {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
            }
            signUpTextView.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
            }
        }

    }


    private fun findAccount(email: String, password: String): Boolean {
        println("Main Activity -> findAccount: email: $email, password: $password")
        return true
    }


}