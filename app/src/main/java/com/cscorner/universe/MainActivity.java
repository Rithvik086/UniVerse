package com.cscorner.universe;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

    }
}