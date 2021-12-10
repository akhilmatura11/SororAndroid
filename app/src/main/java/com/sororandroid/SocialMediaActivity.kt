package com.sororandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sororandroid.databinding.ActivitySocialMediaBinding

class SocialMediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySocialMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButtonSocialMedia.setOnClickListener {
            finish()
        }
    }
}