package com.cscorner.universe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class customuggridadapter extends RecyclerView.Adapter<customuggridadapter.ugVieHolder> {


    private List<UGshape> ugList;

    public customuggridadapter(List<UGshape> ugList, RecyclerViewClickListener clickListener) {
        this.ugList = ugList;
        this.clickListener = clickListener;
    }

    private RecyclerViewClickListener clickListener;




    @NonNull
    @Override
    public ugVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_ugitem_layout,parent,false);
        return new ugVieHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ugVieHolder holder,  int position) {
        UGshape ug = ugList.get(position);
        holder.ugimg.setImageResource(ug.getUgimg());
        holder.ugname.setText(ug.getUgname());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(position,position+1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return ugList.size();
    }

    public static class ugVieHolder extends RecyclerView.ViewHolder{
        TextView ugname;
        ImageView ugimg;


        public ugVieHolder(@NonNull View itemView) {
            super(itemView);
            ugname = itemView.findViewById(R.id.ugtxt);

            ugimg=itemView.findViewById(R.id.ugimg);
        }
    }

}
