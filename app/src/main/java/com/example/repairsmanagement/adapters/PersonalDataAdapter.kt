package com.example.repairsmanagement.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.repairsmanagement.R
import com.example.repairsmanagement.data.PersonalData
import kotlinx.android.synthetic.main.view_catagory_items.view.*

class PersonalDataAdapter(val list:List<PersonalData>) : RecyclerView.Adapter<PersonalDataAdapter.ViewHolder>() {
    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        var fullName = itemview.full_name
        var email = itemview.email
        var address = itemview.address
        var mobileNumber = itemview.mobile_number
        var workDetails = itemview.work_details
        var pay = itemview.pay
        var occupation = itemview.occupation_dropdown

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_catagory_items2,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = list[position]
        val appendaddress = " ,"+itemData.city+" ,"+itemData.district+" ,"+itemData.state+" (${itemData.pinCode})"+" ,"+itemData.country

        Log.i("on bind view holder","$position")
        with(holder){
            fullName.text = itemData.fullname
            email.text = itemData.email
            address.text = itemData.address+appendaddress
            mobileNumber.text = itemData.mobileNumber
            workDetails.text = itemData.workDetails
            pay.text = itemData.pay
            occupation.text = itemData.Occupation
        }
    }
}