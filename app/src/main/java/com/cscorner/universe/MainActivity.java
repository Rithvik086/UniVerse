package com.cscorner.universe;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView uggrid;
ArrayList<UGshape> uGshapeArrayList;
customuggridadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //adapter View
        uggrid=findViewById(R.id.grdview);
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
        adapter = new customuggridadapter(uGshapeArrayList,getApplicationContext());
        uggrid.setAdapter(adapter);
        uggrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                UGshape selectedug = uGshapeArrayList.get(position);
                switch(selectedug.getUgname()){
                    case "UG 1":
                        i = new Intent(getApplicationContext(), ug1sem.class);
                        break;
                    case "UG 2":
                       i = new Intent(getApplicationContext(), ug2sem.class);
                       break;
                    case "UG 3":
                        i = new Intent(getApplicationContext(), ug3sem.class);
                        break;
                    case "UG 4":
                        i = new Intent(getApplicationContext(), ug4sem.class);
                        break;
                    default :
                        return;
                }
                startActivity(i);

            }
        });

    }
}