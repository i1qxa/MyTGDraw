package com.example.mytgdraw.listParticipant

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytgdraw.R

class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val participantNumber = itemView.findViewById<TextView>(R.id.tvNumber)
    val participantName = itemView.findViewById<TextView>(R.id.tvName)
}