package com.cscorner.universe.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cscorner.universe.R
import com.cscorner.universe.model.BookModel
import com.cscorner.universe.model.SubjectModel

class SubGridRV(private val onSubclick:(SubjectModel)->Unit):RecyclerView.Adapter<SubGridRV.SubjectViewHolder>() {
    private lateinit var sublist : List<SubjectModel>


    inner class SubjectViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val subname = itemView.findViewById<TextView>(R.id.subfragtxt)
        fun bindsub(ugsub: SubjectModel){
            subname.text = ugsub.name
            itemView.setOnClickListener {
                onSubclick(ugsub)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subject_item,parent,false)
        return SubjectViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sublist.size
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val currentsub = sublist[position]
        holder.bindsub(currentsub)
    }
fun subList(list: List<SubjectModel>){
    sublist = list
    notifyDataSetChanged()

}

}