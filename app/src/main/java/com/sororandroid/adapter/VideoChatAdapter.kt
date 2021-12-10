package com.sororandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sororandroid.databinding.ItemChatMessageBinding
import com.sororandroid.model.ChatMessages

class VideoChatAdapter(context: Context, private val messages: MutableList<ChatMessages>) :
    RecyclerView.Adapter<VideoChatAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemChatMessageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(chatMessage: ChatMessages) {
            binding.chatMessages = chatMessage
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChatMessageBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(messages[position])
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    fun updateMessages(messages: MutableList<ChatMessages>) {
    //    this.messages.clear()
      //  this.messages.addAll(messages)
    }

}
