package com.example.repairsmanagement.data

data class PersonalData(var fullname:String,var address:String,var country:String,var state:String ,
                        var district:String,var city:String,var pinCode:String,var Occupation:String,var mobileNumber:String) {
    var email:String = "Email id not available"
    var pay:String = "Pay data is not available"
    var workDetails:String = "Work Details is not available"
    constructor() : this("null","null","null","null","null","null","null","null","null")
}