package com.cscorner.universe;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ug3sem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ug3sem);
        ListView ug3semlst;
        ArrayList<Sem> ug3semarraylist;
        customsemadapter adaptersem;

        //Adapter view
        ug3semlst = findViewById(R.id.ug3semlstview);
        //Data Source
        ug3semarraylist = new ArrayList<>();
        Sem sem5 = new Sem(R.drawable.semnobg,"SEM 5");
        Sem sem6 = new Sem(R.drawable.semnobg,"SEM 6");
        ug3semarraylist.add(sem5);
        ug3semarraylist.add(sem6);
        //Adapter
        adaptersem = new customsemadapter(ug3semarraylist,getApplicationContext());
        ug3semlst.setAdapter(adaptersem);
    }
}