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

import java.util.ArrayList;

public class customuggridadapter extends ArrayAdapter<UGshape> {
    private ArrayList<UGshape> ugshapeArrayList;
    Context context;

    public customuggridadapter( ArrayList<UGshape> ugshapeArrayList, Context context) {
        super(context, R.layout.grid_ugitem_layout,ugshapeArrayList);
        this.ugshapeArrayList = ugshapeArrayList;
        this.context = context;
    }
    private static class MyViewHolder{
        TextView ugname;
        ImageView ugimg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       UGshape ug = getItem(position);
       MyViewHolder myViewHolder;
       if(convertView==null){
           myViewHolder = new MyViewHolder();
           LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.grid_ugitem_layout,parent,false);

           myViewHolder.ugname=(TextView) convertView.findViewById(R.id.ugtxt);
           myViewHolder.ugimg=(ImageView) convertView.findViewById(R.id.ugimg);
           convertView.setTag(myViewHolder);
       }else{
           myViewHolder = (MyViewHolder) convertView.getTag();
       }
       myViewHolder.ugname.setText(ug.getUgname());
       myViewHolder.ugimg.setImageResource(ug.getUgimg());
       return convertView;
    }
}
