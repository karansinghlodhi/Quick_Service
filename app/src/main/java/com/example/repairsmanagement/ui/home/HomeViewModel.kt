package com.example.repairsmanagement.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.repairsmanagement.data.PersonalData
import com.example.repairsmanagement.staticdata.StaticData
import com.google.firebase.database.FirebaseDatabase

class HomeViewModel : ViewModel() {
    val list = mutableListOf<PersonalData>()
    var listCopy = StaticData.listCopy
    //var listCopy = mutableListOf<PersonalData>()

    val databaseReference = FirebaseDatabase.getInstance().getReference("UserPersonalData")

}