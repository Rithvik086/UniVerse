package com.cscorner.universe.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.cscorner.universe.adapters.SubGridRV
import com.cscorner.universe.R
import com.cscorner.universe.viewmodel.SubjectViewModel
import com.cscorner.universe.model.SubjectModel


class SemSubjectListFragment : Fragment() {
private val args : SemSubjectListFragmentArgs by navArgs()
    private lateinit var subjectViewModel: SubjectViewModel
    private lateinit var subrecyclervw:RecyclerView
private lateinit var subadp:SubGridRV

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_sem_subject_list, container, false)
        val subanimation = view.findViewById<LottieAnimationView>(R.id.animationsub)
        subanimation.playAnimation()

subjectViewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)

        subrecyclervw= view.findViewById(R.id.recyclerViewsub)
        subrecyclervw.layoutManager = GridLayoutManager(context,2)
        subadp = SubGridRV{selectedsub -> onSubselected(selectedsub)}
        subrecyclervw.adapter = subadp

        val ugYear = args.ugYearName
        val ugSem = args.ugSemName
        subjectViewModel.loadSubjects(ugSem)

        subjectViewModel.subprot.observe(viewLifecycleOwner, Observer { subjectList -> subadp.subList(subjectList) })

        return view
    }

    private fun onSubselected(ugsub: SubjectModel) {
        val subaction = SemSubjectListFragmentDirections.actionSemSubjectListFragmentToPdfListFragment(ugYearName = args.ugYearName, ugSemName = args.ugSemName, subselected = ugsub.name)
        findNavController().navigate(subaction)

    }


}