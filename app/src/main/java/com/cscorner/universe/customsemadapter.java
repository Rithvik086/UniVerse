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

public class customsemadapter extends ArrayAdapter<Sem> {
    private ArrayList<Sem> semArrayList;
    Context context;

    public customsemadapter( ArrayList<Sem> semArrayList, Context context) {
        super(context, R.layout.sem_layout,semArrayList);
        this.semArrayList = semArrayList;
        this.context = context;
    }
    private static class MyViewHolder{
        TextView ugsemno;
        ImageView ugsemimg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Sem semno = getItem(position);
        MyViewHolder myViewHolder;
        if(convertView==null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.sem_layout,parent,false);
            myViewHolder.ugsemno=(TextView) convertView.findViewById(R.id.ugsemno);
            myViewHolder.ugsemimg=(ImageView) convertView.findViewById(R.id.ugsemimg);
        }else{
            myViewHolder = (MyViewHolder) convertView.getTag();
        }
        myViewHolder.ugsemno.setText(semno.getSemno());
        myViewHolder.ugsemimg.setImageResource(semno.getUgsemimg());
        return convertView;
    }
}
