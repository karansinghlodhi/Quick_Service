package com.example.repairsmanagement.data

data class ApplicationUser (val usrnameUid:String, val number:String, var detailsAvailable:Boolean){

    constructor() : this("","",false)
}