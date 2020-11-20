package com.example.repairsmanagement.ui.EditDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EditDetailsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Edit Details Fragment"
    }
    val text: LiveData<String> = _text
}