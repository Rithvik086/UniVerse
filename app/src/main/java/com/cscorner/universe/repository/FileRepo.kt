package com.cscorner.universe.repository

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.airbnb.lottie.network.FileExtension
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class FileRepo(private val context: Context) {

    private val storageref:StorageReference = FirebaseStorage.getInstance().reference


    fun downloadFile(ugYear:String,ugSem:String,sub: String,filename:String){
        val ref = storageref.child("$ugYear/$ugSem/$sub/$filename.pdf")

        ref.downloadUrl.addOnSuccessListener { uri ->
            downloadFiles(context,filename,".pdf",Environment.DIRECTORY_DOWNLOADS,uri.toString())
        }.addOnFailureListener {
            Toast.makeText(context,"Failed to download",Toast.LENGTH_SHORT).show()
            
        }
    }

    private fun downloadFiles(context: Context, fileName: String, fileExtension: String, destinationDir: String, url: String) {
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri = Uri.parse(url)
        val request = DownloadManager.Request(uri)

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(destinationDir, "$fileName$fileExtension")

        downloadManager.enqueue(request)
    }


    fun requestNotificationPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(context,android.Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){
ActivityCompat.requestPermissions(context as Activity, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),1)

            }

        }
    }

}