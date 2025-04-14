package com.cscorner.universe.fragments

import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.cscorner.universe.adapters.PdfRV
import com.cscorner.universe.R
import com.cscorner.universe.viewmodel.PdfViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class PdfListFragment : Fragment() {
    private val args:PdfListFragmentArgs by navArgs()
    private lateinit var pdfViewModel: PdfViewModel
    private lateinit var recyclerViewpdf: RecyclerView
    private lateinit var pdfadp:PdfRV
    private lateinit var  addPdf: FloatingActionButton
    private lateinit var selectPdfLauncher : ActivityResultLauncher<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Register the PDF selector
        selectPdfLauncher =
            this.registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
                uri?.let {
                    var fileName = getFileNameFromUri(uri)
                    if (!fileName.endsWith(".pdf", ignoreCase = true)) {
                        fileName += ".pdf"
                    }
                    // or use file name from uri if you want
                    pdfViewModel.uploadPdf(it, args.ugYearName, args.ugSemName, args.subselected, fileName)
                }
            }
    }


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

        addPdf = view.findViewById<FloatingActionButton>(R.id.addNewPdf)
        addPdf.setOnClickListener {
            selectPdfLauncher.launch("application/pdf")
        }
    return view
    }


    private fun getFileNameFromUri(uri: Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
            try {
                cursor?.let {
                    if (it.moveToFirst()) {
                        result = it.getString(it.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME))
                    }
                }
            } finally {
                cursor?.close()
            }
        }

        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/')
            if (cut != -1 && cut != null) {
                result = result?.substring(cut + 1)
            }
        }

        return result ?: "UnnamedFile_${System.currentTimeMillis()}.pdf"
    }

}