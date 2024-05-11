package com.example.onlineshop.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineshop.data.repository.LoginRepository
import com.example.onlineshop.databinding.ActivityLoginBinding
import com.example.onlineshop.presentation.`interface`.ActivityBaseInterface
import com.example.onlineshop.presentation.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity(), ActivityBaseInterface {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var loginRepository: LoginRepository
    private val loginMVVM = LoginViewModel.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("LoginActivity OnCreate")

        init()
        setEvents()
    }

    override fun init() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()
        loginRepository = LoginRepository()
        loginMVVM.init(loginRepository)
        dataBinding()
    }

    private fun dataBinding() {
        loginMVVM.observeLoginLiveData().observe(this) {
            if (it) {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    override fun setEvents() {
        binding.apply {
            loginButton.setOnClickListener {
                val email = "dinh.phuc.17.5.2005@gmail.com"
                val password = "00000000"
//                val email = binding.emailEditText.text.toString()
//                val password = binding.passwordEditText.text.toString()
                if (findAccount(email, password)) {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                }
            }
            signUpTextView.setOnClickListener {
                startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
                finish()
            }
        }

    }


    private fun findAccount(email: String, password: String): Boolean {
        if (email.isEmpty() || password.length < 8)
            return false
        loginMVVM.login(email, password)
        return true
    }


}