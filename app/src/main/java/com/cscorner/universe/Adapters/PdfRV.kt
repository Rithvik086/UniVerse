package com.cscorner.universe.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cscorner.universe.R
import com.cscorner.universe.model.BookModel

class PdfRV:RecyclerView.Adapter<PdfRV.pdfViewHolder>() {
     private lateinit var pdflist : List<BookModel>

    inner class pdfViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val pdfname:TextView = itemView.findViewById(R.id.pdfnametextView)
val downlaodpdf:Button = itemView.findViewById(R.id.pdfdownload)
        fun bind(pdf:BookModel){
            pdfname.text = pdf.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pdfViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bookpdf_item,parent,false)
    return pdfViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pdflist.size
    }

    override fun onBindViewHolder(holder: pdfViewHolder, position: Int) {
        val currentpdf = pdflist[position]
        Log.d("PdfRV", "Binding item at position $position: $currentpdf")
        holder.bind(currentpdf)

    }

    fun booklist(list : List<BookModel>){
        pdflist = list
        notifyDataSetChanged()
    }

}