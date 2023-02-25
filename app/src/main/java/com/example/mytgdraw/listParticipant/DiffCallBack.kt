package com.example.mytgdraw.listParticipant

import androidx.recyclerview.widget.DiffUtil
import com.example.mytgdraw.Participant

class DiffCallBack:DiffUtil.ItemCallback<Participant>() {
    override fun areItemsTheSame(oldItem: Participant, newItem: Participant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Participant, newItem: Participant): Boolean {
        return oldItem == newItem
    }
}