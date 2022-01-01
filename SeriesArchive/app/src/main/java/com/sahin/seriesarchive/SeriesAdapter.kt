package com.sahin.seriesarchive

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sahin.seriesarchive.databinding.RecylerRowBinding

class SeriesAdapter(val seriesList:ArrayList<Series>) : RecyclerView.Adapter<SeriesAdapter.SeriesHolder>() {

    class  SeriesHolder(val binding:RecylerRowBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesHolder {
        val binding = RecylerRowBinding.inflate(LayoutInflater.from(parent.context))
        return SeriesHolder(binding)
    }

    override fun onBindViewHolder(holder: SeriesHolder, position: Int) {
        holder.binding.recyclerViewTextView.text=seriesList.get(position).name
        holder.itemView.setOnClickListener{
            val intent=Intent(holder.itemView.context,AddSeries::class.java)
            intent.putExtra("control",0)
            intent.putExtra("id",seriesList.get(position).id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return seriesList.size
    }

}