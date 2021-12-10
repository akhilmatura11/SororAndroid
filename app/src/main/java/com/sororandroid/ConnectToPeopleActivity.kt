package com.sororandroid

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.sororandroid.databinding.ActivityConnectToPeopleBinding

class ConnectToPeopleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConnectToPeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler1 = Handler()
        val run1 =
            Runnable { binding.connectToPeopleTitle.text = "Will Shortly Find Your Connection" }

        handler1.postDelayed(run1, 3000)

        val handler2 = Handler()
        val run2 = Runnable {
            val intent = Intent(baseContext, MatchFoundActivity::class.java)
            startActivity(intent)
            finish()
        }

        handler2.postDelayed(run2, 5000)

        binding.cancelButton.setOnClickListener {
            handler1.removeCallbacks(run1)
            handler2.removeCallbacks(run2)
            finish()
        }

    }
}