package com.cscorner.universe.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cscorner.universe.R
import com.cscorner.universe.model.UGYearModel

class UgGridRV(private val onItemClick:(UGYearModel)->Unit):
    RecyclerView.Adapter<UgGridRV.UGViewHolder>() {
    private lateinit var uglist:List<UGYearModel>

    inner class UGViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val ugImageView:ImageView = itemView.findViewById(R.id.ugitemimg)
        val ugname:TextView = itemView.findViewById(R.id.ugitemname)
        fun bind(ugYear: UGYearModel) {
            ugImageView.setImageResource(ugYear.img)
            ugname.text = ugYear.name
            itemView.setOnClickListener {
                onItemClick(ugYear)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UGViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ug_item,parent,false)
        return UGViewHolder(view)
    }

    override fun getItemCount(): Int {
        return uglist.size
    }
    fun list(list: List<UGYearModel>){
        uglist = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UGViewHolder, position: Int) {
        val currentug = uglist[position]
        holder.bind(currentug)
    }


}