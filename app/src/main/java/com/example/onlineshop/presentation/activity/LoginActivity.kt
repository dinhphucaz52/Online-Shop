package com.example.onlineshop.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.data.api.AppResource
import com.example.onlineshop.data.repository.AuthenticationRepository
import com.example.onlineshop.databinding.ActivityLoginBinding
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface
import com.example.onlineshop.presentation.viewmodel.AuthenticationViewModel
import com.google.gson.JsonParser

class LoginActivity : AppCompatActivity(), ActivityBaseInterface {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var authenticationRepository: AuthenticationRepository

    private val authenticationMVVM by lazy {
        AuthenticationViewModel.getInstance()
    }

    private val sharedPreferences by lazy {
        getSharedPreferences("my_app_preferences", Context.MODE_PRIVATE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        setEvents()
    }

    override fun init() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        authenticationRepository = AuthenticationRepository()
        authenticationMVVM.init(authenticationRepository)
        dataBinding()
    }

    private fun dataBinding() {
        authenticationMVVM.observeSignInLiveData().observe(this) {
            when (it) {
                is AppResource.Error -> {
                    val t = JsonParser.parseString(it.error)
                    Toast.makeText(
                        this@LoginActivity,
                        t.asJsonObject["message"].asString,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                is AppResource.Success -> {
                    val user = it.data
                    sharedPreferences.edit().putString("token", user?.token).apply()
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
    }

    override fun setEvents() {
        binding.apply {
            loginButton.setOnClickListener {
                var email = binding.emailEditText.text.toString()
                var password = binding.passwordEditText.text.toString()
                if (email == "") email = "dinh.phuc.17.5.25@gmail.com"
                if (password == "") password = "00000000"
                login(email, password)
            }
            signUpTextView.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
                finish()
            }
        }

    }


    private fun login(email: String, password: String) {
        println("email: $email, password: $password")
        if (email.isEmpty()) {
            Toast.makeText(this@LoginActivity, "Email is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if (!(email.contains("@") && email.contains("."))) {
            Toast.makeText(this@LoginActivity, "Email is invalid", Toast.LENGTH_SHORT).show()
            return
        }
        if (password.isEmpty()) {
            Toast.makeText(this@LoginActivity, "Password is empty", Toast.LENGTH_SHORT).show()
            return
        }
        if (password.length < 8) {
            Toast.makeText(this@LoginActivity, "Password is too short", Toast.LENGTH_SHORT).show()
            return
        }
        authenticationMVVM.login(email, password)
    }


}