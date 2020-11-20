package com.example.repairsmanagement.ui.home

import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.opengl.Visibility
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.repairsmanagement.R
import com.example.repairsmanagement.adapters.PersonalDataAdapter
import com.example.repairsmanagement.data.PersonalData
import com.example.repairsmanagement.staticdata.StaticData
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.home_fragment.*
import java.util.*
import kotlin.time.*

class HomeFragment : Fragment() {


    lateinit var recyclerView: RecyclerView
    lateinit var searchView: SearchView
    private lateinit var occupationSpinner: Spinner
    private lateinit var occupationAdapter: ArrayAdapter<String>

    //    private lateinit var additionalSpinner: Spinner
//    private lateinit var additionalAdapter: ArrayAdapter<String>
    private var additionalArrayList = mutableListOf<String>()

    //    private lateinit var additional : String
    private var additionalSearchData = MutableLiveData<String>()
    private lateinit var statesAdapter: ArrayAdapter<String>
    private lateinit var statesSpinner: Spinner
    private lateinit var citySpinner: Spinner
    private lateinit var cityAdapter: ArrayAdapter<String>
    private lateinit var districtSpinner: Spinner
    private lateinit var districtAdapter: ArrayAdapter<String>
    private lateinit var listener2: ValueEventListener
    private var occupationArrayList = mutableListOf<String>()
    private var occupation = StaticData.occupationDefaultItem
    private lateinit var progressDialog: ProgressDialog

    private var statesArrayList = mutableListOf<String>()
    private var states = StaticData.stateDefaultItem
    private var cityArrayList = mutableListOf<String>()
    private var city = StaticData.cityDefaultItem
    private var districtArrayList = mutableListOf<String>()
    private var district = StaticData.disctrictDefaultItem
    private lateinit var selectLocation: Button
    private lateinit var search: Button

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.home_fragment, container, false)
        recyclerView = root.findViewById(R.id.recycler_view_home)
        searchView = root.findViewById(R.id.searchData)
        occupationSpinner = root.findViewById(R.id.occupation_dropdown)
        statesSpinner = root.findViewById(R.id.states_dropdown)
        citySpinner = root.findViewById(R.id.city_dropdown)
        districtSpinner = root.findViewById(R.id.district_dropdown)
        selectLocation = root.findViewById(R.id.select_location)
        search = root.findViewById(R.id.search_button)
        //additionalSpinner = root.findViewById(R.id.additional_dropdown)

        return root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    @ExperimentalTime
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        recyclerView.adapter = PersonalDataAdapter(viewModel.list)
        Log.i("Activity", "occupation list$occupationArrayList")


        if (occupationArrayList.isEmpty())
            occupationArrayList.addAll(StaticData.getOccupation())
        if (statesArrayList.isEmpty()) {
            statesArrayList.addAll(StaticData.getStates())
            if (statesArrayList[0].isNotEmpty())
                states = statesArrayList[0]
        }
        if (districtArrayList.isEmpty()) {
            districtArrayList.addAll(StaticData.getDistrict(0))
            district = districtArrayList[0]
        }


        if (cityArrayList.isEmpty()) {
            cityArrayList.addAll(StaticData.getCityData(0, 2, this.requireContext()))
            city = cityArrayList[0]
        }
//        additionalSearchData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//            additionalSearchQuery(it)
//        })

        progressDialog = ProgressDialog(this.requireContext())
        progressDialog.setTitle("Loading Please Wait")

        Log.i("data", "viewModel.personalData().toString()")
        Log.i("activity", "create")
        //progressDialog.show()
        if (additionalArrayList.isEmpty())
            additionalArrayList.addAll(resources.getStringArray(R.array.addtional))

//        additionalAdapter = ArrayAdapter(this.requireContext(),R.layout.support_simple_spinner_dropdown_item,additionalArrayList)
//        additionalSpinner.adapter = additionalAdapter
        occupationAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            occupationArrayList
        )
        occupationSpinner.adapter = occupationAdapter
        statesAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            statesArrayList
        )
        statesSpinner.adapter = statesAdapter
        districtAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            districtArrayList
        )
        districtSpinner.adapter = districtAdapter
        districtAdapter.setNotifyOnChange(true)
        cityAdapter = ArrayAdapter(
            this.requireContext(),
            R.layout.support_simple_spinner_dropdown_item,
            cityArrayList
        )
        citySpinner.adapter = cityAdapter
        cityAdapter.setNotifyOnChange(true)

        listener2 = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
//                snapshot.children.forEach {
//                    it.ref.removeValue()
//                    Log.i("delete","complete")
//                }
                viewModel.listCopy.clear()
                viewModel.list.clear()
                snapshot.children.forEach {

                    val data = it.getValue(PersonalData::class.java)
                    if (data != null) {
                        viewModel.list.add(data)
                        viewModel.listCopy.add(data)
                    }
                    //toastMessage(data.toString())
                    (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
                }
                if (progressDialog.isShowing)
                    progressDialog.dismiss()
                if (!snapshot.exists()) {
                    toastMessage("record is not available")
                    viewModel.list.clear()
                    (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                toastMessage("error field")
            }
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                if (query.isNullOrEmpty()) {
//                    viewModel.list.clear()
//                    queryForOccupation(occupation)
//                    queryForLocationFilter()
//                } else {
//                    additionalSearchQuery(query)
//                    //additionalSearchData.value = newText
//                }
//                (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
//                //toastMessage(newText!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                additionalSearchQuery(newText!!)
                (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()


                //Log.i("no of calls for search",newText!!)
//                if (newText.isNullOrEmpty()){
//                    viewModel.list.clear()
//                    queryForOccupation(occupation)
//                    queryForLocationFilter()
//                }
//                else{
//                    additionalSearchQuery(newText)
//                    //additionalSearchData.value = newText
//                }
//                (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
//                //toastMessage(newText!!)
                return false
            }

        })

//        additionalSpinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                additional = additionalArrayList[position]
//                searchView.queryHint = "Enter $additional"
//                if(additionalSearchData.value!=null)
//                additionalSearchData.value = additionalSearchData.value
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//        }

        occupationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (occupationArrayList != null)
                    occupation = occupationArrayList[position]
//                statesSpinner.setSelection(0)
//                citySpinner.setSelection(0)
//                Log.i("no of calls","$occupation")
//                if (occupation.equals(StaticData.occupationDefaultItem))
//                    searchView.queryHint = "${resources.getString(R.string.search_query)} Person"
//                else
//                    searchView.queryHint = "${resources.getString(R.string.search_query)} $occupation"
//                //queryForOccupation(occupation)
//                queryForLocationFilter()
//                additionalSearchQuery(searchView.query.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.i("occupation nothing", "no")
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
                //Log.i("city data 2","${cityArrayList}cityArrayList")
                //cityArrayList.clear()
                districtArrayList.clear()
                cityArrayList.clear()
                cityArrayList.addAll(mutableListOf(StaticData.cityDefaultItem))
                districtArrayList.addAll(StaticData.getDistrict(position))
                //cityArrayList.add("select city")
                // cityArrayList.addAll(StaticData.getDistrict(position))
                districtSpinner.setSelection(0)
                citySpinner.setSelection(0)


                //Log.i("city data 3","${cityArrayList}cityArrayList position $position ${StaticData.getCityData(position)}")

//                queryForLocationFilter()
//                additionalSearchQuery(searchView.query.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //comment added implementation is not available
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
                citySpinner.setSelection(0)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                toastMessage("nothing selected from district list")
            }

        }

        citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position < cityArrayList.size)
                    city = cityArrayList[position]

                //queryForLocationFilter()
                //additionalSearchQuery(searchView.query.toString())
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //comment added implementation is not available
                toastMessage("no city available")
            }
        }
    }

    override fun onStart() {
        super.onStart()
        //Log.i("startlist","${viewModel.listCopy}")
//        if (viewModel.listCopy.isEmpty()) {
//            progressDialog.show()
//            viewModel.databaseReference.limitToFirst(100).addListenerForSingleValueEvent(listener2)
//        } else {
//            viewModel.list.addAll(viewModel.listCopy)
//            (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
//
//        }
        Log.i("activity", "start1")
        //Log.i("activityoccupation","${StaticData.getOccupation()}")

    }


    override fun onStop() {
        super.onStop()
        Log.i("activity", "stop")
        occupationSpinner.setSelection(0)
        //additionalSearchData.value=""
        searchView.setQuery("", true)

        viewModel.databaseReference.removeEventListener(listener2)
        viewModel.databaseReference.child(occupation).child(states)
            .child(district).child(city).limitToFirst(100).removeEventListener(listener2)
    }

    override fun onResume() {
        super.onResume()
        selectLocation.setOnClickListener {
            if (!statesSpinner.isVisible) {
                occupationSpinner.visibility = View.VISIBLE
                statesSpinner.visibility = View.VISIBLE
                districtSpinner.visibility = View.VISIBLE
                citySpinner.visibility = View.VISIBLE
                search.visibility = View.VISIBLE
                searchView.visibility = View.VISIBLE
            }
        }
        search.setOnClickListener {
            if (validateForm()) {
                selectLocation.text = states + ", " + district + ", " + city
                occupationSpinner.visibility = View.GONE
                statesSpinner.visibility = View.GONE
                districtSpinner.visibility = View.GONE
                citySpinner.visibility = View.GONE
                search.visibility = View.GONE
                val query = viewModel.databaseReference.child(occupation).child(states)
                    .child(district).child(city).limitToFirst(50)
                if (isNetworkConnected()){
                    progressDialog.show()
                    query.addListenerForSingleValueEvent(listener2)
                }
                else
                    toastMessage("Network is not available")

            }
        }
        Log.i("activity", "resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("activity", "pause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("activity", "destroy")
    }


    fun toastMessage(message: String) {
        Toast.makeText(this.requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    fun queryForOccupation(occupation: String): MutableList<PersonalData> {
        val newlist = mutableListOf<PersonalData>()
        Log.i("no of calls output", "$occupation")
        viewModel.list.clear()
        if (occupation == StaticData.occupationDefaultItem) {
            //progressDialog.show()
            viewModel.list.addAll(viewModel.listCopy)
            newlist.addAll(viewModel.listCopy)
            //Log.i("no of calls output","$newlist")
            //Log.i("no of calls output2","${viewModel.list}")
            //progressDialog.dismiss()
            (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
            //viewModel.databaseReference.addListenerForSingleValueEvent(listener2)
            //progressDialog.dismiss()
            return newlist
        } else {
            progressDialog.show()
            for (lists in viewModel.listCopy) {
                if (lists.Occupation.equals(occupation)) {
                    viewModel.list.add(lists)
                    newlist.add(lists)
                }
            }
            (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
            progressDialog.dismiss()
            if (viewModel.list.isEmpty()) {
                toastMessage("data is not available")
            }
            //viewModel.databaseReference.orderByChild("occupation").equalTo(occupation).addListenerForSingleValueEvent(listener2)
            //progressDialog.dismiss()

            return newlist
        }
    }

    fun queryForLocationFilter(): MutableList<PersonalData> {
        val newlist = mutableListOf<PersonalData>()

        //if (viewModel.list.isNotEmpty())
        newlist.addAll(queryForOccupation(occupation))

        if (newlist.isNotEmpty()) {
            if (states.equals(StaticData.stateDefaultItem)) {
                //Log.i("filtersstateondefault","$newlist")
                return newlist
            } else if (city.equals(StaticData.disctrictDefaultItem)) {
                viewModel.list.clear()
                for (lists in newlist) {
                    if (lists.state.equals(states)) {
                        viewModel.list.add(lists)
                    }
                }
                //Log.i("filtersscityondefault","$newlist")
                newlist.clear()
                newlist.addAll(viewModel.list)
                (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()

            } else {
                viewModel.list.clear()
                for (lists in newlist) {
                    if (lists.state.equals(states) && lists.city.equals(city)) {
                        viewModel.list.add(lists)
                    }
                }
                //Log.i("filterforbothondefault","$newlist")
                newlist.clear()
                newlist.addAll(viewModel.list)
                (recyclerView.adapter as PersonalDataAdapter).notifyDataSetChanged()
            }
        }
        return newlist
    }

    fun additionalSearchQuery(newText: String) {
        //Log.i("newList","$newList")
        //Log.i("newviewlist","$newList")
        viewModel.list.clear()
        if (newText.isEmpty()) {
            viewModel.list.addAll(viewModel.listCopy)
        }
        else {
            for (data in viewModel.listCopy) {
                if (data.pinCode.toLowerCase(Locale.ROOT).contains(newText.trim())) {
                    viewModel.list.add(data)
                } else if (data.address.toLowerCase(Locale.ROOT).contains(newText.trim())) {
                    viewModel.list.add(data)
                }
            }
        }
    }

    fun validateForm(): Boolean {
        var flag = true
        if (occupation.equals(StaticData.occupationDefaultItem)) {
            val view = occupationSpinner.selectedView as TextView
            view.error = "select Occupation first"
            //toastMessage("Please Select Occupation")
            flag = false
        }
        if (states.equals(StaticData.stateDefaultItem)) {
            val view = statesSpinner.selectedView as TextView
            view.setError("select data first")

            //toastMessage("Please Select States")
            flag = false
        }

        if (district.equals(StaticData.disctrictDefaultItem)) {
            val view = districtSpinner.selectedView as TextView
            view.error = "select district first"
            //toastMessage("Please Select District")
            flag = false
        }
        if (city.equals(StaticData.cityDefaultItem)) {
            val view = citySpinner.selectedView as TextView
            view.error = "select city first"
            //toastMessage("Please Select City")
            flag = false
        }
        return flag
    }

    fun isNetworkConnected():Boolean {
        var flag :Boolean = false
        val connMgr = requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if(networkInfo!=null)
            flag = true
        return flag
    }

}