package com.sororandroid

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.sororandroid.adapter.VideoChatAdapter
import com.sororandroid.databinding.ActivityVideoCallBinding
import com.sororandroid.model.ChatMessages

class VideoCallActivity : AppCompatActivity() {
    private var micStatus: Boolean = true
    var chatStatus: Boolean = false
    private var messages = mutableListOf<ChatMessages>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityVideoCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = VideoChatAdapter(this, messages)
        val linearLayoutManager = LinearLayoutManager(this);
        linearLayoutManager.stackFromEnd = true;
        binding.videoMessageRecyclerView.layoutManager = linearLayoutManager
        binding.videoMessageRecyclerView.adapter = adapter

        binding.videoMic.setOnClickListener {
            if (micStatus) {
                micStatus = false
                binding.videoMic.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.video_muted_mic
                    )
                )
            } else {
                micStatus = true
                binding.videoMic.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.video_mic
                    )
                )
            }
        }
        binding.videoChat.setOnClickListener {
            if (chatStatus) {
                chatStatus = false
                binding.newMessageLayout.visibility = View.GONE
                binding.videoChatLayout.visibility = View.GONE
            } else {
                chatStatus = true
                binding.newMessageLayout.visibility = View.VISIBLE
                binding.videoChatLayout.visibility = View.VISIBLE
            }
        }

        binding.videoDropCall.setOnClickListener {
            finish()
        }

        val handler1 = Handler()
        val run1 =
            Runnable {
                binding.videoEndTimerText.text = "1:25 left"
                binding.videoAddTime.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.video_add_time_orange
                    )
                )
            }

        handler1.postDelayed(run1, 37500)

        binding.videoNewMessageSend.setOnClickListener {
            val message = binding.videoNewMessageEditText.text.toString().trim()
            if (message.isNotEmpty()) {
                messages.add(ChatMessages("You", message))
                adapter.updateMessages(messages)
                val position = adapter.itemCount - 1;
                linearLayoutManager.scrollToPositionWithOffset(position, 0);
                adapter.notifyDataSetChanged()
                binding.videoNewMessageEditText.text?.clear()
            }
        }
        val afterTextChangedListener: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.toString().isEmpty()) {
                    binding.videoNewMessageSend.visibility = View.GONE
                } else {
                    binding.videoNewMessageSend.visibility = View.VISIBLE
                }
            }
        }
        binding.videoNewMessageEditText.addTextChangedListener(afterTextChangedListener)


    }

}