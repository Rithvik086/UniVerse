package com.cscorner.universe;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ug4sem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ug4sem);
        ListView ug4semlst;
        ArrayList<Sem> ug4semarraylist;
        customsemadapter adaptersem;

        //Adapter view
        ug4semlst = findViewById(R.id.ug4semlstview);
        //Data Source
        ug4semarraylist = new ArrayList<>();
        Sem sem7 = new Sem(R.drawable.semnobg,"SEM 7");
        Sem sem8 = new Sem(R.drawable.semnobg,"SEM 8");
        ug4semarraylist.add(sem7);
        ug4semarraylist.add(sem8);
        //Adapter
        adaptersem = new customsemadapter(ug4semarraylist,getApplicationContext());
        ug4semlst.setAdapter(adaptersem);
    }
}