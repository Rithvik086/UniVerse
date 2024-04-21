package com.cscorner.universe;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ug2sem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ug2sem);
        ListView ug2semlst;
        ArrayList<Sem> ug2semarraylist;
        customsemadapter adaptersem;

        //Adapter view
        ug2semlst = findViewById(R.id.ug2semlstview);
        //Data Source
        ug2semarraylist = new ArrayList<>();
        Sem sem3 = new Sem(R.drawable.semnobg,"SEM 3");
        Sem sem4 = new Sem(R.drawable.semnobg,"SEM 4");
        ug2semarraylist.add(sem3);
        ug2semarraylist.add(sem4);
        //Adapter
        adaptersem = new customsemadapter(ug2semarraylist,getApplicationContext());
        ug2semlst.setAdapter(adaptersem);
    }
}