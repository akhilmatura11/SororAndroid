package com.sororandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sororandroid.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpTextLogin.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.loginButtonLayout.setOnClickListener {
            //TODO code for login successful
        }

        binding.backButtonLogin.setOnClickListener {
            finish()
        }

        binding.facebookLoginLayout.setOnClickListener{
            //TODO
        }

        binding.googleLoginLayout.setOnClickListener{
            //TODO
        }
    }
}