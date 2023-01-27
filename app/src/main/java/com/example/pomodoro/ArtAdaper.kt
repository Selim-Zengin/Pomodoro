package com.example.pomodoro

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pomodoro.databinding.RecylerRowBinding

class ArtAdaper(val artList:ArrayList<Art>):RecyclerView.Adapter<ArtAdaper.ArtHolder>() {
    class ArtHolder(val binding:RecylerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding=RecylerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        holder.binding.recyclerViewTextView.text=artList.get(position).name
        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,MainActivity3::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  artList.size
    }
}
