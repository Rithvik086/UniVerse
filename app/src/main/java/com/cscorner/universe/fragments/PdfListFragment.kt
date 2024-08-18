package com.cscorner.universe.fragments

import android.os.Bundle

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
import com.cscorner.universe.adapters.PdfRV
import com.cscorner.universe.R
import com.cscorner.universe.viewmodel.PdfViewModel




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


        val ugYear = args.ugYearName
        val ugSem = args.ugSemName
        val sub = args.subselected
    val animationpdf = view.findViewById<LottieAnimationView>(R.id.animationpdf)
        animationpdf.playAnimation()

        pdfViewModel = ViewModelProvider(this).get(PdfViewModel::class.java)

        recyclerViewpdf = view.findViewById(R.id.recyclerViewpdf)
        recyclerViewpdf.layoutManager = LinearLayoutManager(context)
pdfadp = PdfRV{bookModel -> pdfViewModel.downloadPdf(ugYear,ugSem,sub,bookModel.name) }
        recyclerViewpdf.adapter = pdfadp

        pdfViewModel.loadPdf(ugYear,ugSem,sub)

        pdfViewModel.pdfprot.observe(viewLifecycleOwner, Observer { pdfList ->





            pdfadp.booklist(pdfList) })
    return view
    }



}