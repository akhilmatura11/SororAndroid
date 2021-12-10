package com.sororandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sororandroid.databinding.ActivityMatchFoundBinding

class MatchFoundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMatchFoundBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.letsConnectLayout.setOnClickListener {
            val intent = Intent(this, VideoCallActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.skipConnectText.setOnClickListener {
            val intent = Intent(this, ConnectToPeopleActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.cancelButton.setOnClickListener {
            finish()
        }
    }
}