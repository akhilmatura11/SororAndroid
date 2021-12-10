package com.sororandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sororandroid.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doItLaterWelcome.setOnClickListener {
            val intent = Intent(this, WhatYourThingActivity::class.java)
            intent.putExtra("title", false)
            startActivity(intent)
        }

        binding.completeProfileButtonLayout.setOnClickListener {
            val intent = Intent(this, CompleteYourProfileActivity::class.java)
            startActivity(intent)
        }
    }
}