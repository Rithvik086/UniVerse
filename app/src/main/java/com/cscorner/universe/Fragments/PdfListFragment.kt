package com.cscorner.universe.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.cscorner.universe.Adapters.PdfRV
import com.cscorner.universe.R
import com.cscorner.universe.ViewModel.PdfViewModel




class PdfListFragment : Fragment() {
    private val args:PdfListFragmentArgs by navArgs()
    private lateinit var pdfViewModel: PdfViewModel
    private lateinit var recyclerViewpdf: RecyclerView
    private lateinit var pdfadp:PdfRV






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_pdf_list, container, false)
    val animationpdf = view.findViewById<LottieAnimationView>(R.id.animationpdf)
        animationpdf.playAnimation()

        pdfViewModel = ViewModelProvider(this).get(PdfViewModel::class.java)

        recyclerViewpdf = view.findViewById(R.id.recyclerViewpdf)
        recyclerViewpdf.layoutManager = LinearLayoutManager(context)
pdfadp = PdfRV()
        recyclerViewpdf.adapter = pdfadp
        val ugYear = args.ugYearName
        val ugsem = args.ugSemName
        val subSelected = args.subselected
        pdfViewModel.loadPdf(subSelected)

        pdfViewModel.pdfprot.observe(viewLifecycleOwner, Observer { pdfList ->

            Log.d("PdfFragment", "PDF List: $pdfList")



            pdfadp.booklist(pdfList) })
    return view
    }



}