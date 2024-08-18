package com.cscorner.universe.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cscorner.universe.model.SemesterModel

class SemViewModel : ViewModel() {
    private val _semlist = MutableLiveData<List<SemesterModel>>()
    val semlistprot: MutableLiveData<List<SemesterModel>> get() = _semlist


    init {

        _semlist.value = emptyList()
    }


    fun loadSemesters(ugYear: String) {
        val semesters = when (ugYear) {
            "UG 1" -> listOf(
                SemesterModel("1", "Sem 1"),
                SemesterModel("2", "Sem 2")
            )

            "UG 2" -> listOf(
                SemesterModel("3", "Sem 3"),
                SemesterModel("4", "Sem 4")
            )

            "UG 3" -> listOf(
                SemesterModel("5", "Sem 5"),
                SemesterModel("6", "Sem 6")
            )

            "UG 4" -> listOf(
                SemesterModel("7", "Sem 7"),
                SemesterModel("8", "Sem 8")
            )

            else -> emptyList()
        }

        // Update the LiveData
        _semlist.value = semesters
    }
}
