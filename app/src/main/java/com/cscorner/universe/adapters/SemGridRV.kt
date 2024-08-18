package com.cscorner.universe.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cscorner.universe.R
import com.cscorner.universe.model.SemesterModel

class SemGridRV(private val onSemclick:(SemesterModel)-> Unit):RecyclerView.Adapter<SemGridRV.SemViewHolder>() {

    private lateinit var semList : List<SemesterModel>


    inner class SemViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val semname:TextView = itemView.findViewById(R.id.semfragtxt)
        fun bindSem(ugsem:SemesterModel){
            semname.text = ugsem.name
            itemView.setOnClickListener {
                onSemclick(ugsem)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.semester_item,parent,false)
        return SemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return semList.size
    }

    override fun onBindViewHolder(holder: SemViewHolder, position: Int) {
        val currentsem = semList[position]
        holder.bindSem(currentsem)
    }

    fun semlist(list: List<SemesterModel>){
        semList = list
        notifyDataSetChanged()
    }

}