package com.example.repairsmanagement.ui.contactUs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactUsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Help Fragment"
    }
    val text: LiveData<String> = _text
}