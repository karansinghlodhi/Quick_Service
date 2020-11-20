package com.example.repairsmanagement.utilityClasses

import android.app.ProgressDialog
import android.content.Context

class ProgressTask(context: Context) {
    var progressDialog:ProgressDialog

    init {
        progressDialog = ProgressDialog(context)
        progressDialog.setCancelable(false)
        progressDialog.setTitle("Login Please Wait")
    }
    fun show(){
        progressDialog.show()
    }

    fun dismiss(){
        if(progressDialog.isShowing)
            progressDialog.dismiss()
    }

}