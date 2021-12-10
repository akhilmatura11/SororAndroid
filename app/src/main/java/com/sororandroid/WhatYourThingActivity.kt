package com.sororandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.sororandroid.databinding.ActivityWhatYourThingBinding


class WhatYourThingActivity : AppCompatActivity() {
    private val aboutMeList = mutableListOf<String>()
    private val interestList = mutableListOf<String>()
    private lateinit var binding: ActivityWhatYourThingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatYourThingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.getBooleanExtra("title", false))
            binding.thingsAboutYouLayout.visibility = View.VISIBLE
        else
            binding.thingsAboutYouLayout.visibility = View.GONE

        binding.aboutMeChipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip = group.findViewById(checkedId)

            if (chip.isChecked) {
                aboutMeList.add(chip.text.toString())
            } else {
                aboutMeList.remove(chip.text.toString())
            }

            updateContinueButton()
        }

        binding.interestChipGroup.setOnCheckedChangeListener { group, checkedId ->
            val chip: Chip = group.findViewById(checkedId)

            if (chip.isChecked) {
                interestList.add(chip.text.toString())
            } else {
                interestList.remove(chip.text.toString())
            }

            updateContinueButton()
        }

        binding.continueButtonLayout.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun updateContinueButton() {
        if (aboutMeList.size > 0 && interestList.size > 0) {
            binding.continueButtonLayout.setCardBackgroundColor(getColor(R.color.color_primary_dark))
            binding.ccontinueButtonText.isEnabled = true
            binding.ccontinueButtonText.alpha = 1.0f
        } else {
            binding.continueButtonLayout.setCardBackgroundColor(getColor(R.color.disabled_color))
            binding.ccontinueButtonText.isEnabled = false
            binding.ccontinueButtonText.alpha = 0.4f
        }
    }
}

