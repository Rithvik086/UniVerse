package com.cscorner.universe;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ug1sem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ug1sem);
        ListView ug1semlst;
        ArrayList<Sem> ug1semarraylist;
        customsemadapter adaptersem;
        setContentView(R.layout.activity_ug1sem);
        //Adapter view
        ug1semlst = findViewById(R.id.ug1semlstview);
        //Data Source
        ug1semarraylist = new ArrayList<>();
        Sem sem1 = new Sem(R.drawable.semnobg,"SEM 1");
        Sem sem2 = new Sem(R.drawable.semnobg,"SEM 2");
        ug1semarraylist.add(sem1);
        ug1semarraylist.add(sem2);
        //Adapter
        adaptersem = new customsemadapter(ug1semarraylist,getApplicationContext());
        ug1semlst.setAdapter(adaptersem);
    }
}