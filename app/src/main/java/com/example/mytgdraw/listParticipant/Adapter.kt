package com.example.mytgdraw.listParticipant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.mytgdraw.Participant
import com.example.mytgdraw.R

class Adapter:ListAdapter<Participant,ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = R.layout.participant_item
        return ViewHolder(
            layoutInflater.inflate(
                layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder){
            holder.participantNumber.text = item.id.toString()
            holder.participantName.text = item.getHiddenNumber()
        }
        holder.itemView.setOnClickListener {
            holder.participantName.text = item.name
        }
    }
}