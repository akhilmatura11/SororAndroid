package com.sororandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sororandroid.databinding.ActivityPublicProfileBinding

class PublicProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPublicProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButtonPublicProfile.setOnClickListener {
            finish()
        }

        binding.publicProfileSubmitLayout.setOnClickListener {
            finish()
        }
    }
}