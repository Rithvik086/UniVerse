package com.cscorner.universe.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cscorner.universe.R
import com.cscorner.universe.model.UGYearModel

class UgModelViewModel : ViewModel() {
     private val _ugList = MutableLiveData<List<UGYearModel>>()
    val ugList : MutableLiveData<List<UGYearModel>> get() = _ugList

    init {
        loadUGData()
    }

    private fun loadUGData() {
        val Uglist = listOf(
            UGYearModel(R.drawable.ug1final,"UG 1") ,
            UGYearModel(R.drawable.ug2final,"UG 2") ,
            UGYearModel(R.drawable.ug3final,"UG 3") ,
            UGYearModel(R.drawable.ug4final,"UG 4") ,
        )
        _ugList.value = Uglist
    }


}