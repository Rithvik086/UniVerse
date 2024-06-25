package com.cscorner.universe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {
    RecyclerView uggrid;
    ArrayList<UGshape> uGshapeArrayList;
    customuggridadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //adapter View
        uggrid=findViewById(R.id.recyclerViewug);
        uggrid.setLayoutManager(new GridLayoutManager(this,2));
        //Data source
        uGshapeArrayList = new ArrayList<>();
        UGshape ug1 = new UGshape(R.drawable.ug1nobg,"UG 1");
        UGshape ug2 = new UGshape(R.drawable.ug2nobg,"UG 2");
        UGshape ug3 = new UGshape(R.drawable.ug3nobg,"UG 3");
        UGshape ug4 = new UGshape(R.drawable.ug4nobg,"UG 4");
        uGshapeArrayList.add(ug1);
        uGshapeArrayList.add(ug2);
        uGshapeArrayList.add(ug3);
        uGshapeArrayList.add(ug4);
        adapter = new customuggridadapter(uGshapeArrayList,this);
        uggrid.setAdapter(adapter);


    }


    @Override
    public void onClick(int position, int itemClicked) {
        switch (itemClicked){
            case 1 :
                Intent i1= new Intent(MainActivity.this, ug1sem.class);
                startActivity(i1);
                break;
            case 2:
                // Intent for item 2
                Intent i2 = new Intent(MainActivity.this, ug2sem.class);
                startActivity(i2);
                break;
            case 3:
                // Intent for item 3
                Intent i3 = new Intent(MainActivity.this, ug3sem.class);
                startActivity(i3);
                break;
            case 4:
                // Intent for item 4
                Intent i4 = new Intent(MainActivity.this, ug4sem.class);
                startActivity(i4);
                break;
            default:
                // Handle default case or do nothing
                break;
        }
    }
}
