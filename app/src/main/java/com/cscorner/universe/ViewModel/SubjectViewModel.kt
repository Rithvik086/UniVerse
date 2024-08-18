package com.cscorner.universe.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cscorner.universe.model.SubjectModel

class SubjectViewModel : ViewModel() {
    private val _sublist = MutableLiveData<List<SubjectModel>>()
    val subprot:MutableLiveData<List<SubjectModel>>get() = _sublist


    init {
        _sublist.value = emptyList()
    }

    fun loadSubjects(ugSem:String){

        val subjects = when(ugSem){

            "Sem 1"-> listOf(
                SubjectModel("","CP"),
                SubjectModel("","DSMA"),
                SubjectModel("","DLD"),
                SubjectModel("","OCW")

            )
            "Sem 2"-> listOf(
                    SubjectModel("","PS"),
                SubjectModel("","DSA"),
                SubjectModel("","SS"),
                SubjectModel("","CA"),
                SubjectModel("","BEC"),

                    )

            "Sem 3"-> listOf(
                SubjectModel("","ADSA"),
                SubjectModel("","DBMS"),
                SubjectModel("","RANAC"),
                SubjectModel("","OS"),
                SubjectModel("","OOPS"),



                )
            "Sem 4"-> listOf(
                SubjectModel("","FFSD"),
                SubjectModel("","AI"),
                SubjectModel("","ToC"),
                SubjectModel("","CCN"),




                )
            "Sem 5"-> listOf(
                SubjectModel("","FDFED"),
                SubjectModel("","CC"),
                SubjectModel("","BTA"),
                SubjectModel("","CV"),
                SubjectModel("","ICS"),
                SubjectModel("","NLP"),
                SubjectModel("","ML"),
                SubjectModel("","IR"),
                SubjectModel("","DM"),
                SubjectModel("","CGM"),



                )

            "Sem 6"-> listOf(
                SubjectModel("","WBD"),
                SubjectModel("","DC"),
                SubjectModel("","HPC"),
                SubjectModel("","MS"),
                SubjectModel("","CGC"),
                SubjectModel("","GTA"),
                SubjectModel("","RI"),
                SubjectModel("","BI"),
                SubjectModel("","IS"),
                SubjectModel("","MFQC"),
                SubjectModel("","IASE"),
                SubjectModel("","DM"),




                )

            "Sem 7"-> listOf(
                SubjectModel("","FQC"),
                SubjectModel("","VAR"),
                SubjectModel("","IoT"),
                SubjectModel("","CRYPTO"),
                SubjectModel("","DIP"),




                )

            "Sem 8"-> listOf(
                SubjectModel("","CB"),
                SubjectModel("","IIoT"),
                SubjectModel("","WN"),
                SubjectModel("","SDN"),




                )



            else -> emptyList()
        }
        _sublist.value = subjects
    }



}