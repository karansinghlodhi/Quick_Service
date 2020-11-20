package com.example.repairsmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.repairsmanagement.data.PersonalData
import com.example.repairsmanagement.staticdata.StaticData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_personal_data_page.*

class PersonalDataPage : AppCompatActivity() {
    var databaseReference = FirebaseDatabase.getInstance().reference
    lateinit var personalData:PersonalData
    lateinit var personUID :String
    lateinit var firebaseUser: FirebaseUser
    lateinit var occupationSpinner: Spinner
    lateinit var occupationArrayList:MutableList<String>
    lateinit var occupation:String
    lateinit var occupationAdapter: ArrayAdapter<String>
    lateinit var statesSpinner: Spinner
    lateinit var statesArrayList:MutableList<String>
    lateinit var states:String
    lateinit var statesAdapter: ArrayAdapter<String>
    lateinit var districtSpinner: Spinner
    lateinit var districtArrayList:MutableList<String>
    lateinit var district:String
    lateinit var districtAdapter: ArrayAdapter<String>
    lateinit var citySpinner: Spinner
    lateinit var cityArrayList:MutableList<String>
    var city = StaticData.cityDefaultItem
    lateinit var cityAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_data_page)
        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        personUID=firebaseUser.uid
        FirebaseDatabase.getInstance().getReference(personUID)
        pmobile_number.setText(firebaseUser.phoneNumber)

        occupationSpinner= findViewById(R.id.poccupation)
        occupationArrayList = StaticData.getOccupation()
        occupationAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,occupationArrayList)
        occupationSpinner.adapter = occupationAdapter

        statesSpinner = findViewById(R.id.pstate)
        statesArrayList = StaticData.getStates()
        statesAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,statesArrayList)
        statesSpinner.adapter = statesAdapter

        districtSpinner = findViewById(R.id.pdistrict)
        districtArrayList = StaticData.getDistrict(0)
        districtAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,districtArrayList)
        districtSpinner.adapter = districtAdapter
        districtAdapter.setNotifyOnChange(true)

        citySpinner = findViewById(R.id.pcity)
        cityArrayList = StaticData.getCityData(0,0,this)
        cityAdapter = ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,cityArrayList)
        citySpinner.adapter = cityAdapter
        cityAdapter.setNotifyOnChange(true)

        occupationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //toastMessage("occupationItemSelected:", occupationArrayList[position])
                occupation= occupationArrayList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        statesSpinner.onItemSelectedListener  = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                states = statesArrayList[position]
                districtArrayList.clear()
                districtArrayList.addAll(StaticData.getDistrict(position))

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        districtSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (districtArrayList.isNotEmpty())
                district = districtArrayList[position]

                cityArrayList.clear()
                cityArrayList.addAll(StaticData.getCityData(statesArrayList.indexOf(states),position,this@PersonalDataPage))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position<cityArrayList.size)
                    city = cityArrayList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        p_ok.setOnClickListener {
            if(validateform()){
                val name = pfullname.text.toString()
                val address = paddress.text.toString()
                val country = pcountry.text.toString()
                val email = pemail.text.toString()
//                val state = pstate.text.toString()
//                val city = pcity.text.toString()
                val pincode = ppincode.text.toString()
//                var occupation = "Others"
                val mobile = pmobile_number.text.toString()
                val pay = ppay.text.toString()
                val workDetails = pwork_details.text.toString()

                personalData = PersonalData(name,address,country,states,district,city,pincode,occupation,mobile)
                if(pay.isNotEmpty()){
                    personalData.pay=pay
                }
                if(workDetails.isNotEmpty())
                    personalData.workDetails=workDetails
                if(email.isNotEmpty())
                    personalData.email=email

                databaseReference.child("UserPersonalData").child(personUID)
                    .setValue(personalData)
                databaseReference.child("UserPersonalData").child(occupation).child(states)
                    .child(district).child(city).child(personUID)
                    .setValue(personalData)

                databaseReference.child("ApplicationUser").child(personUID).updateChildren(mapOf<String,Boolean>("detailsAvailable" to true))

                startActivity(Intent(this,MainActivity::class.java))
            }
        }
    }

    private fun validateform():Boolean {
        //Toast.makeText(this,"PersonalDataPage:"+personUID,Toast.LENGTH_LONG).show()
        var flag = true;
        if(pfullname.text.isEmpty()){
            pfullname.error="name is required item"
            flag = false
        }
        if(pcountry.text.isEmpty()){
            pcountry.error="Country is required item"
            flag = false
        }

        if(paddress.text.isEmpty()){
            paddress.error="Address is required item"
            flag = false
        }

        if(states.equals(StaticData.stateDefaultItem)){
            val view = statesSpinner.selectedView as TextView
            view.setError("select data first")

            //toastMessage("Please Select","States")
            flag = false
        }

        if(district.equals(StaticData.disctrictDefaultItem)){
            val view = districtSpinner.selectedView as TextView
            view.error = "select district first"
            //toastMessage("Please Select","District")
            flag = false
        }
        if(city.equals(StaticData.cityDefaultItem)){
            val view = citySpinner.selectedView as TextView
            view.error = "select city first"
            //toastMessage("Please Select","City")
            flag = false
        }

        if(ppincode.text.isEmpty()){
            ppincode.error="Pincode is required item"
            flag = false
        }

        if(occupation.equals(StaticData.occupationDefaultItem)){
            val view = occupationSpinner.selectedView as TextView
            view.error = "select Occupation first"
            //Toast.makeText(this, "Please Select Occupation", Toast.LENGTH_SHORT).show()
            flag = false
        }

        if(pmobile_number.text.isEmpty()){
            pmobile_number.error="Mobile Number is required item"
            flag = false
        }
        return flag
    }

//    fun toastMessage(tag:String,message:String){
//        Toast.makeText(this,tag+message,Toast.LENGTH_LONG).show()
//    }
}