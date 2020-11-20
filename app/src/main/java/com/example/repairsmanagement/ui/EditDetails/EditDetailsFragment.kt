package com.example.repairsmanagement.ui.EditDetails

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.repairsmanagement.LoginPage
import com.example.repairsmanagement.R
import com.example.repairsmanagement.data.PersonalData
import com.example.repairsmanagement.staticdata.StaticData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_edit_details.*

class EditDetailsFragment : Fragment() {

    private lateinit var editDetailsViewModel: EditDetailsViewModel
    private var user = FirebaseAuth.getInstance().currentUser
    lateinit var personUID: String
    lateinit var firebaseUser: FirebaseUser
    lateinit var personalData: PersonalData
    lateinit var ok: Button
    lateinit var occupationSpinner: Spinner
    lateinit var occupationArrayList: MutableList<String>
    var occupation = StaticData.occupationDefaultItem
    lateinit var occupationAdapter: ArrayAdapter<String>
    lateinit var statesSpinner: Spinner
    lateinit var statesArrayList: MutableList<String>
    var states = StaticData.stateDefaultItem
    lateinit var statesAdapter: ArrayAdapter<String>
    lateinit var districtSpinner: Spinner
    lateinit var districtArrayList: MutableList<String>
    var district = StaticData.disctrictDefaultItem
    lateinit var districtAdapter: ArrayAdapter<String>
    lateinit var citySpinner: Spinner
    lateinit var cityArrayList: MutableList<String>
    var city = StaticData.cityDefaultItem
    lateinit var cityAdapter: ArrayAdapter<String>
    lateinit var previousOccupation: String
    lateinit var previousStates: String
    lateinit var previousDistrict: String
    lateinit var previousCity: String
    var flagForStateSpinner = 0
    var flagForDistrictSpinner = 0


    var databaseReference = FirebaseDatabase.getInstance().reference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        editDetailsViewModel =
            ViewModelProvider(this).get(EditDetailsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_edit_details, container, false)
        firebaseUser = FirebaseAuth.getInstance().currentUser!!
        personUID = firebaseUser.uid

        occupationSpinner = root.findViewById(R.id.eoccupation)
        occupationArrayList = StaticData.getOccupation()
        occupationAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            occupationArrayList
        )
        occupationSpinner.adapter = occupationAdapter

        statesSpinner = root.findViewById(R.id.estate)
        statesArrayList = StaticData.getStates()
        statesAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            statesArrayList
        )
        statesSpinner.adapter = statesAdapter


        districtSpinner = root.findViewById(R.id.edistrict)
        districtArrayList = StaticData.getDistrict(0)
        districtAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            districtArrayList
        )
        districtSpinner.adapter = districtAdapter
//        districtAdapter.setNotifyOnChange(true)
        citySpinner = root.findViewById(R.id.ecity)
        cityArrayList = StaticData.getCityData(0, 0, this.requireContext())
        cityAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            cityArrayList
        )
        citySpinner.adapter = cityAdapter
//        cityAdapter.setNotifyOnChange(true)
        Log.i("city Data", "$districtArrayList")

        ok = root.findViewById(R.id.e_ok)
        ok.setOnClickListener {
            if (isNetworkConnected()) {
                updateDetails()
            } else {
                toastMessage("network is not available", "")
            }
        }


        return root
    }

    override fun onStart() {
        super.onStart()
        val progressDialog = ProgressDialog(this.requireContext())
        progressDialog.setTitle("Loading Please Wait")
        progressDialog.show()

        occupationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //toastMessage("occupationItemSelected:", occupationArrayList[position])
                if (occupationArrayList != null)
                    occupation = occupationArrayList[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.i("onnothingselected", "in Occupations")
            }

        }

        statesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                states = statesArrayList[position]
                Log.i("city data 2", "$districtArrayList")
                districtArrayList.clear()
                districtArrayList.addAll(StaticData.getDistrict(position))
                //districtSpinner.setSelection(0,false)
                if (flagForStateSpinner > 1) {
                    districtSpinner.setSelection(0)
                }
                flagForStateSpinner++
                districtAdapter.notifyDataSetChanged()
                Log.i(
                    "city data 3",
                    "$districtArrayList position $position ${StaticData.getDistrict(position)}"
                )
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.i("onnothingselected", "in states")
            }

        }


        districtSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position < districtArrayList.size) {
                    district = districtArrayList[position]
                }

                cityArrayList.clear()
                cityArrayList.addAll(
                    StaticData.getCityData(
                        statesArrayList.indexOf(states),
                        position,
                        context!!
                    )
                )
                if (flagForDistrictSpinner > 1) {
                    citySpinner.setSelection(0)
                }
                flagForDistrictSpinner++
                cityAdapter.notifyDataSetChanged()
                //citySpinner.setSelection(0)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //comment added implementation is not available
                Log.i("onnothingselected", "in district")
                toastMessage("no city available", "")
            }

        }

        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.i("cityspinner", "called $position")
                if (position < cityArrayList.size) {
                    city = cityArrayList[position]
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        // toastMessage("onstartStarted","onstart")
        val databaseRefe = FirebaseDatabase.getInstance().getReference("UserPersonalData")

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.hasChild(personUID))
                    getDetails(databaseRefe.child(personUID))
                progressDialog.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("oncancelled", "EditDetails Page")
            }

        }

        if (isNetworkConnected()) {
            if (user != null)
                databaseRefe.addListenerForSingleValueEvent(listener)
            else {
                toastMessage("not registered user please register first", ".")
                startActivity(Intent(this.requireContext(), LoginPage::class.java))
            }
        } else {
            toastMessage("network is not available", "")
            if (progressDialog.isShowing)
                progressDialog.dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        //districtSpinner.setSelection(districtArrayList)
    }

    fun toastMessage(tag: String, message: String) {
        Toast.makeText(this.requireContext(), tag + message, Toast.LENGTH_SHORT).show()
    }

    fun getDetails(databaseReference: DatabaseReference) {
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val personalData = snapshot.getValue(PersonalData::class.java)
                //toastMessage("personalData:",personUID+personalData!!.address)
                efullname.setText(personalData!!.fullname)
                eaddress.setText(personalData.address)
                ecountry.setText(personalData.country)
                eemail.setText(personalData.email)
//                estate.setText(personalData.state)
//                ecity.setText(personalData.city)
                epincode.setText(personalData.pinCode)
                previousOccupation = personalData.Occupation
                previousStates = personalData.state
                previousDistrict = personalData.district
                previousCity = personalData.city

                //eoccupation.setText(personalData.Occupation)
                occupationSpinner.setSelection(occupationAdapter.getPosition(personalData.Occupation))
                val tempStatePosition = statesAdapter.getPosition(personalData.state)
                statesSpinner.setSelection(tempStatePosition)

                districtArrayList.clear()
                districtArrayList.addAll(StaticData.getDistrict(tempStatePosition))
                val tempDistrictPostion = districtAdapter.getPosition(personalData.district)
                districtSpinner.setSelection(tempDistrictPostion)
                cityArrayList.clear()
                cityArrayList.addAll(
                    StaticData.getCityData(
                        tempStatePosition,
                        tempDistrictPostion,
                        context!!
                    )
                )
                citySpinner.setSelection(cityAdapter.getPosition(personalData.city))


                ework_details.setText(personalData.workDetails)
                emobile_number.setText(personalData.mobileNumber)
                epay.setText(personalData.pay)

                Log.i("getdata", "called complete")

            }

            override fun onCancelled(error: DatabaseError) {
                Log.i("oncancelled", "editdetails Page")
            }


        })

    }

    fun updateDetails() {
        //p_ok.setOnClickListener
        if (validateform()) {
            val name = efullname.text.toString()
            val address = eaddress.text.toString()
            val country = ecountry.text.toString()
            val email = eemail.text.toString()
//                val state = "no state selected"
//                val city = ecity.text.toString()
            val pincode = epincode.text.toString()
            val mobile = emobile_number.text.toString()
            val pay = epay.text.toString()
            val workDetails = ework_details.text.toString()





            personalData = PersonalData(
                name,
                address,
                country,
                states,
                district,
                city,
                pincode,
                occupation,
                mobile
            )

            if (pay.isNotEmpty()) {
                personalData.pay = pay
            }
            if (workDetails.isNotEmpty())
                personalData.workDetails = workDetails
            if (email.isNotEmpty())
                personalData.email = email

            databaseReference.child("UserPersonalData").child(occupation).child(states)
                .child(district).child(city).child(personUID)
                .setValue(personalData)
            databaseReference.child("UserPersonalData").child(personUID).setValue(personalData)

            if (!city.equals(previousCity) || !occupation.equals(previousOccupation))
                databaseReference.child("UserPersonalData").child(previousOccupation)
                    .child(previousStates).child(previousDistrict)
                    .child(previousCity).child(personUID)
                    .addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            snapshot.ref.removeValue()
                        }

                        override fun onCancelled(error: DatabaseError) {

                        }

                    })

            previousOccupation = occupation
            previousStates = states
            previousDistrict = district
            previousCity = city

            toastMessage("Personal Data ", "Updated Successfully")
            StaticData.listCopy.clear()
        }

    }

    private fun validateform(): Boolean {
        //Toast.makeText(this.requireContext(),"Edit details Page:"+personUID,Toast.LENGTH_LONG).show()
        var flag = true;
        if (efullname.text.isEmpty()) {
            efullname.error = "name is required item"
            flag = false
        }
        if (ecountry.text.isEmpty()) {
            ecountry.error = "Country is required item"
            flag = false
        }

        if (eaddress.text.isEmpty()) {
            eaddress.error = "Address is required item"
            flag = false
        }
        if (occupation.equals(StaticData.occupationDefaultItem)) {
            val view = occupationSpinner.selectedView as TextView
            view.error = "select Occupation first"
            toastMessage("Please Select", "Occupation")
            flag = false
        }

        if (states.equals(StaticData.stateDefaultItem)) {
            val view = statesSpinner.selectedView as TextView
            view.setError("select data first")

            toastMessage("Please Select", "States")
            flag = false
        }

        if (district.equals(StaticData.disctrictDefaultItem)) {
            val view = districtSpinner.selectedView as TextView
            view.error = "select district first"
            toastMessage("Please Select", "District")
            flag = false
        }
        if (city.equals(StaticData.cityDefaultItem)) {
            val view = citySpinner.selectedView as TextView
            view.error = "select city first"
            toastMessage("Please Select", "City")
            flag = false
        }

        if (epincode.text.isEmpty()) {
            epincode.error = "Pincode is required item"
            flag = false
        }



        if (emobile_number.text.isEmpty()) {
            emobile_number.error = "Mobile Number is required item"
            flag = false
        }
        return flag
    }

    fun isNetworkConnected(): Boolean {
        var flag: Boolean = false
        val connMgr = this.requireContext()
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if (networkInfo != null)
            flag = networkInfo.isConnected
        return flag
    }

}