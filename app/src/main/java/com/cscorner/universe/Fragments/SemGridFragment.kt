package com.cscorner.universe.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.cscorner.universe.Adapters.SemGridRV
import com.cscorner.universe.R
import com.cscorner.universe.ViewModel.SemViewModel
import com.cscorner.universe.model.SemesterModel


class SemGridFragment : Fragment() {
    private val args: SemGridFragmentArgs by navArgs()
    private lateinit var viewModelsem: SemViewModel
    private lateinit var recyclerViewsem: RecyclerView
    private lateinit var adpsem:SemGridRV





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val animationsem = view?.findViewById<LottieAnimationView>(R.id.animationsem)
        animationsem?.playAnimation()
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_sem_grid, container, false)
        viewModelsem  = ViewModelProvider(this).get(SemViewModel::class.java)
        recyclerViewsem = view.findViewById(R.id.recyclerViewsem)
        recyclerViewsem.layoutManager = LinearLayoutManager(context)
        adpsem = SemGridRV{ selectedsem -> onSemslected(selectedsem) }
        recyclerViewsem.adapter = adpsem
         val ugYear = args.ugYearName
        viewModelsem.loadSemesters(ugYear)
        viewModelsem.semlistprot.observe(viewLifecycleOwner, Observer {
            semesterList -> adpsem.semlist(semesterList)
        })







        return view
    }
    fun onSemslected(ugsem:SemesterModel){

        val semaction = SemGridFragmentDirections.actionSemGridFragmentToSemSubjectListFragment(ugYearName = args.ugYearName, ugSemName = ugsem.name)
        findNavController().navigate(semaction)
    }



}