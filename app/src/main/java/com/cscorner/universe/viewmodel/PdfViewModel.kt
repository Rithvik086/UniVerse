package com.cscorner.universe.viewmodel

import android.app.Application
import android.net.Uri
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.cscorner.universe.model.BookModel
import com.cscorner.universe.repository.FileRepo
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask

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


    fun uploadPdf(uri:Uri,ugYear: String,ugSem: String,sub: String,fileName: String){
        val filePah = storage.child("$ugYear/$ugSem/$sub/$fileName");

        filePah.putFile(uri).addOnSuccessListener { taskSnapshot -> taskSnapshot.metadata?.reference?.downloadUrl?.addOnSuccessListener {
           // Toast.makeText(this, "File Uploaded succesfully", Toast.LENGTH_SHORT).show()
            Toast.makeText(getApplication(), "File Uploaded Successfully", Toast.LENGTH_SHORT).show()
            loadPdf(ugYear, ugSem, sub)
        } }.addOnFailureListener {

            Toast.makeText(getApplication(), "Error occurred during file upload", Toast.LENGTH_SHORT).show()
           // Toast.makeText(this, "Some error occured", Toast.LENGTH_SHORT).show()
        }

    }


}
