package com.sororandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sororandroid.databinding.ActivityCompleteYourProfileBinding

class CompleteYourProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCompleteYourProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.publicProfileLayout.setOnClickListener {
            val intent = Intent(this, PublicProfileActivity::class.java)
            startActivity(intent)
        }

        binding.socialMediaLayout.setOnClickListener {
            val intent = Intent(this, SocialMediaActivity::class.java)
            startActivity(intent)
        }

        binding.whatYourThingLayout.setOnClickListener {
            val intent = Intent(this, WhatYourThingActivity::class.java)
            intent.putExtra("title", true)
            startActivity(intent)
        }
    }
}