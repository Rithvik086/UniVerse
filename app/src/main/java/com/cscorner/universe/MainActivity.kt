package com.cscorner.universe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(!ConfigCat.isInMaintainence()!!){
            setContentView(R.layout.activity_main)
        }else{
            setContentView(R.layout.maintainence_layout)

        }






    }






}
