package com.cscorner.universe.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cscorner.universe.model.BookModel
import com.cscorner.universe.repository.FileRepo
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class PdfViewModel(application: Application) : AndroidViewModel(application) {


    private val filerepository:FileRepo = FileRepo(application)
    private val storage:StorageReference = FirebaseStorage.getInstance().reference
    private val _pdflist = MutableLiveData<List<BookModel>>()
    val pdfprot: MutableLiveData<List<BookModel>> get() = _pdflist

    init {
        _pdflist.value = emptyList()
    }

    // PdfViewModel
    fun loadPdf(ugYear:String,ugSem:String,sub:String) {
        val ref = storage.child("$ugYear/$ugSem/$sub")

        ref.listAll().addOnSuccessListener { result ->
            val books = result.items.map { item -> BookModel(item.name.substringBeforeLast(".pdf")) }

            _pdflist.value = books
        }.addOnFailureListener {
            _pdflist.value = emptyList()
        }

    }

    fun downloadPdf(ugYear: String,ugSem: String,sub: String,fileName:String){
        filerepository.downloadFile(ugYear,ugSem,sub, fileName )
    }

    fun reqNotif(){
        filerepository.requestNotificationPermission()
    }

}
