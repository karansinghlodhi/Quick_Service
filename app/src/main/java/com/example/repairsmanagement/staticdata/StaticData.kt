package com.example.repairsmanagement.staticdata

import android.content.Context
import com.example.repairsmanagement.R
import com.example.repairsmanagement.data.PersonalData

class StaticData {
    companion object{
        val districtList = mutableListOf<MutableList<String>>()
        val blockList = mutableListOf<MutableList<String>>()
        val villageList = mutableListOf<MutableList<String>>()
        val occupationList = mutableListOf<String>()
        val statesList = mutableListOf<String>()
        val stateDefaultItem ="SELECT STATE"
        val disctrictDefaultItem ="SELECT DISTRICT"
        val occupationDefaultItem ="SELECT OCCUPATION"
        val cityDefaultItem ="SELECT CITY   "
        val blockDefaultItem ="SELECT BLOCK"
        val villageDefaultItem ="SELECT VILLAGE"
        val listCopy = mutableListOf<PersonalData>()

        fun setData(context: Context){

            if(occupationList.isEmpty()){
                setOccupation(context)
            }
            if(statesList.isEmpty()){
                setStatesData(context)
            }
            val statesize= statesList.size-1
            for(index in 0..statesize)
                districtList.add(mutableListOf())
            setDisctrictData(context)

            val districtSize = districtList.size-1
//            if(subDistrictList.isEmpty())
                //setCityData(context)

//            val subDistrictSize = subDistrictList.size-1
//            for(index in 0..subDistrictSize)
//                blockList.add(mutableListOf())
//            if(blockList.isEmpty())
//                //setBlockData(context)

//            val blockSize = blockList.size-1
//            for(index in 0..blockSize)
//                villageList.add(mutableListOf())
//            if(villageList.isEmpty())
//                setVillageData(context)

            //Toast.makeText(context, "\"occupation data\",\"data : ${occupation} size: ${occupation.size}\"", Toast.LENGTH_SHORT).show()
//            Log.i("occupation data","data : ${occupationList} size: ${occupationList.size}")
//            Log.i("states data","data : ${statesList} size: ${statesList.size}")
//            Log.i("city data","data : ${disctricList} size: ${disctricList.size}")

        }

        private fun setDisctrictData(context: Context){
            if(districtList[0].isEmpty()){
                districtList[0].addAll(context.resources.getStringArray(R.array.ANDAMAN_AND_NICOBAR_ISLANDS))
                districtList[1].addAll(context.resources.getStringArray(R.array.ANDHRA_PRADESH))
                districtList[2].addAll(context.resources.getStringArray(R.array.ARUNACHAL_PRADESH))
                districtList[3].addAll(context.resources.getStringArray(R.array.ASSAM))
                districtList[4].addAll(context.resources.getStringArray(R.array.BIHAR))
                districtList[5].addAll(context.resources.getStringArray(R.array.CHANDIGARH))
                districtList[6].addAll(context.resources.getStringArray(R.array.CHHATTISGARH))
                districtList[7].addAll(context.resources.getStringArray(R.array.DADRA_AND_NAGAR_HAVELI))
                districtList[8].addAll(context.resources.getStringArray(R.array.DAMAN_AND_DIU))
                districtList[9].addAll(context.resources.getStringArray(R.array.DELHI))
                districtList[10].addAll(context.resources.getStringArray(R.array.GOA))
                districtList[11].addAll(context.resources.getStringArray(R.array.GUJARAT))
                districtList[12].addAll(context.resources.getStringArray(R.array.HARYANA))
                districtList[13].addAll(context.resources.getStringArray(R.array.HIMACHAL_PRADESH))
                districtList[14].addAll(context.resources.getStringArray(R.array.JAMMU_AND_KASHMIR))
                districtList[15].addAll(context.resources.getStringArray(R.array.JHARKHAND))
                districtList[16].addAll(context.resources.getStringArray(R.array.KARNATAKA))
                districtList[17].addAll(context.resources.getStringArray(R.array.KERALA))
                districtList[18].addAll(context.resources.getStringArray(R.array.LADAKH))
                districtList[19].addAll(context.resources.getStringArray(R.array.LAKSHADWEEP))
                districtList[20].addAll(context.resources.getStringArray(R.array.MADHYA_PRADESH))
                districtList[21].addAll(context.resources.getStringArray(R.array.MAHARASHTRA))
                districtList[22].addAll(context.resources.getStringArray(R.array.MANIPUR))
                districtList[23].addAll(context.resources.getStringArray(R.array.MEGHALAYA))
                districtList[24].addAll(context.resources.getStringArray(R.array.MIZORAM))
                districtList[25].addAll(context.resources.getStringArray(R.array.NAGALAND))
                districtList[26].addAll(context.resources.getStringArray(R.array.ODISHA))
                districtList[27].addAll(context.resources.getStringArray(R.array.PUDUCHERRY))
                districtList[28].addAll(context.resources.getStringArray(R.array.PUNJAB))
                districtList[29].addAll(context.resources.getStringArray(R.array.RAJASTHAN))
                districtList[30].addAll(context.resources.getStringArray(R.array.SIKKIM))
                districtList[31].addAll(context.resources.getStringArray(R.array.TAMIL_NADU))
                districtList[32].addAll(context.resources.getStringArray(R.array.TELANGANA))
                districtList[33].addAll(context.resources.getStringArray(R.array.THE_DADRA_AND_NAGAR_HAVELI_AND_DAMAN_AND_DIU))
                districtList[34].addAll(context.resources.getStringArray(R.array.TRIPURA))
                districtList[35].addAll(context.resources.getStringArray(R.array.UTTAR_PRADESH))
                districtList[36].addAll(context.resources.getStringArray(R.array.UTTARAKHAND))
                districtList[37].addAll(context.resources.getStringArray(R.array.WEST_BENGAL))
                districtList.add(0, mutableListOf())

                for (index in 0..38)
                    districtList[index].add(0, disctrictDefaultItem)

            }
        }

        private fun setStatesData(context: Context){
            statesList.addAll(context.resources.getStringArray(R.array.states))
            statesList.add(0,stateDefaultItem)
        }
        private fun setOccupation(context: Context){
            occupationList.addAll(context.resources.getStringArray(R.array.occupation))
            occupationList.add(0, occupationDefaultItem)
        }

        private fun setCityData(district : String,context: Context){

        }

        private fun setBlockData(district : String,context: Context){

        }

        private fun setVillageData(context: Context){

        }

        fun getOccupation():MutableList<String>{
            return occupationList
        }

        fun getStates():MutableList<String>{
            return statesList
        }

        fun getDistrict(position : Int):MutableList<String>{
            if(districtList[position].isNotEmpty())
                return districtList[position]
            else
                return mutableListOf(disctrictDefaultItem)
        }

        fun getCityData(statePosition:Int, districtPosition : Int, context: Context):MutableList<String>{
            val cityList = mutableListOf<MutableList<String>>()
            cityList.add(mutableListOf())
            cityList[0].add(cityDefaultItem)
            val list = mutableListOf<String>(cityDefaultItem)


            //*****************************************************************************

            when(statePosition){
                1->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Nicobars))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.North_Middle_Andaman))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.South_Andaman))
                            return list
                        }
                    }
                }
                2->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Adilabad))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Anantapur))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.East_Godavari))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Guntur))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Hyderabad))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Karimnagar))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Khammam))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Krishna))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Kurnool))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Mahbubnagar))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Medak))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Nalgonda))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Nizamabad))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Prakasam))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Rangareddy))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Sri_Potti_Sriramulu_Nellore))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Srikakulam))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Visakhapatnam))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Vizianagaram))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Warangal))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.West_Godavari))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.YSR))
                            return list
                        }

                    }
                }
                3->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Anjaw))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Changlang))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Dibang_Valley))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.East_Kameng))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.East_Siang))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Kurung_Kumey))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Lohit))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Lower_Dibang_Valley))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Lower_Subansiri))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Papum_Pare))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Tawang))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Tirap))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Upper_Siang))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Upper_Subansiri))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.West_Kameng))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.West_Siang))
                            return list
                        }

                    }
                }
                4->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Baksa))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Barpeta))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Bongaigaon))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Cachar))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Chirang))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Darrang))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Dhemaji))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Dhubri))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Dibrugarh))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Dima_Hasao))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Goalpara))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Golaghat))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Hailakandi))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Jorhat))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Kamrup))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Kamrup_Metropolitan))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Karbi_Anglong))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Karimganj))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Kokrajhar))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Lakhimpur))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Morigaon))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Nagaon))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Nalbari))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Sivasagar))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Sonitpur))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Tinsukia))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Udalguri))
                            return list
                        }

                    }
                }
                5->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Pashchim_Champaran))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Purba_Champaran))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Sheohar))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Sitamarhi))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Madhubani))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Supaul))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Araria))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Kishanganj))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Purnia))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Katihar))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Madhepura))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Saharsa))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Darbhanga))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Muzaffarpur))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Gopalganj))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Siwan))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Saran))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Vaishali))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Samastipur))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Begusarai))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Khagaria))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Bhagalpur))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Banka))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Munger))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Lakhisarai))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Sheikhpura))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Nalanda))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Patna))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Bhojpur))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Buxar))
                            return list
                        }
                        31->{
                            list.addAll(context.resources.getStringArray(R.array.Kaimur_Bhabua))
                            return list
                        }
                        32->{
                            list.addAll(context.resources.getStringArray(R.array.Rohtas))
                            return list
                        }
                        33->{
                            list.addAll(context.resources.getStringArray(R.array.Aurangabad))
                            return list
                        }
                        34->{
                            list.addAll(context.resources.getStringArray(R.array.Gaya))
                            return list
                        }
                        35->{
                            list.addAll(context.resources.getStringArray(R.array.Nawada))
                            return list
                        }
                        36->{
                            list.addAll(context.resources.getStringArray(R.array.Jamui))
                            return list
                        }
                        37->{
                            list.addAll(context.resources.getStringArray(R.array.Jehanabad))
                            return list
                        }
                        38->{
                            list.addAll(context.resources.getStringArray(R.array.Arwal))
                            return list
                        }

                    }

                }
                6->{
                    when(districtPosition){
                        1->{
                                list.addAll(context.resources.getStringArray(R.array.CHANDIGARH1))
                            return list
                    }

                    }
                }
                7->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Bastar))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Bijapur1))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Bilaspur1))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.CHHATTISGARH))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Dakshin_Bastar_Dantewada))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Dhamtari))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Durg))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Janjgir_Champa))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Jashpur))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Kabeerdham))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Korba))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Koriya))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Mahasamund))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Narayanpur))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Raigarh1))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Raipur))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Rajnandgaon))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Surguja))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Uttar_Bastar_Kanker))
                            return list
                        }

                    }
                }
                8->{
                    when(districtPosition){
                        1->{
                                list.addAll(context.resources.getStringArray(R.array.DADRA_AND_NAGAR_HAVELI1))
                            return list
                    }

                    }
                }
                9->{
                    when(districtPosition){
                        1->{
                                list.addAll(context.resources.getStringArray(R.array.Daman))
                            return list
                        }
                        2->{
                                list.addAll(context.resources.getStringArray(R.array.Diu))
                            return list
                        }

                    }
                }
                10->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.NCT_OF_DELHI))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Central))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.East))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.New_Delhi))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.North))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.North_East))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.North_West))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.South))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.South_West))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.West))
                            return list
                        }

                    }
                }
                11->{
                    when(districtPosition){
                        1->{
                                list.addAll(context.resources.getStringArray(R.array.North_Goa))
                            return list
                        }
                        2->{
                                list.addAll(context.resources.getStringArray(R.array.South_Goa))
                            return list
                        }

                    }
                }
                12->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Ahmadabad))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Amreli))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Anand))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Banas_Kantha))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Bharuch))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Bhavnagar))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Dohad))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Gandhinagar))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Jamnagar))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Junagadh))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Kachchh))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Kheda))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Mahesana))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Narmada))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Navsari))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Panch_Mahals))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Patan))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Porbandar))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Rajkot))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Sabar_Kantha))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Surat))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Surendranagar))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Tapi))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.The_Dangs))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Vadodara))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Valsad))
                            return list
                        }

                    }
                }
                13->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Ambala))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Bhiwani))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Faridabad))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Fatehabad))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Gurgaon))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Hisar))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Jhajjar))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Jind))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Kaithal))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Karnal))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Kurukshetra))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Mahendragarh))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Mewat))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Palwal))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Panchkula))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Panipat))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Rewari))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Rohtak))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Sirsa))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Sonipat))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Yamunanagar))
                            return list
                        }

                    }
                }
                14->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Bilaspur))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Chamba))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Hamirpur1))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Kangra))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Kinnaur))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Kullu))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Lahul_and_Spiti))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Mandi))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Shimla))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Sirmaur))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Solan))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Una))
                            return list
                        }

                    }
                }
                15->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Anantnag))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Badgam))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Bandipore))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Baramula))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Doda))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Ganderbal))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Jammu))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Kargil))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Kathua))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Kishtwar))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Kulgam))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Kupwara))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Leh_Ladakh))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Pulwama))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Punch))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Rajouri))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Ramban))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Reasi))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Samba))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Shupiyan))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Srinagar))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Udhampur))
                            return list
                        }

                    }
                }
                16->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Bokaro))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Chatra))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Deoghar))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Dhanbad))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Dumka))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Garhwa))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Giridih))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Godda))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Gumla))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Hazaribagh))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Jamtara))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Khunti))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Kodarma))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Latehar))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Lohardaga))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Pakur))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Palamu))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Pashchimi_Singhbhum))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Purbi_Singhbhum))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Ramgarh))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Ranchi))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Sahibganj))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Saraikela_Kharsawan))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Simdega))
                            return list
                        }

                    }
                }
                17->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Bagalkot))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Bangalore))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Bangalore_Rural))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Belgaum))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Bellary))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Bidar))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Bijapur))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Chamarajanagar))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Chikkaballapura))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Chikmagalur))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Chitradurga))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Dakshina_Kannada))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Davanagere))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Dharwad))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Gadag))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Gulbarga))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Hassan))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Haveri))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Kodagu))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Kolar))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Koppal))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Mandya))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Mysore))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Raichur))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Ramanagara))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Shimoga))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Tumkur))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Udupi))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Uttara_Kannada))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Yadgir))
                            return list
                        }

                    }
                }
                18->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Alappuzha))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Ernakulam))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Idukki))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Kannur))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Kasaragod))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Kollam))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Kottayam))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Kozhikode))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Malappuram))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Palakkad))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Pathanamthitta))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Thiruvananthapuram))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Thrissur))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Wayanad))
                            return list
                        }

                    }
                }
                19->{
                    when(districtPosition){

                    }
                }
                20->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.LAKSHADWEEP1))
                            return list
                        }
                    }
                }
                21->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Alirajpur))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Anuppur))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Ashoknagar))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Balaghat))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Barwani))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Betul))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Bhind))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Bhopal))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Burhanpur))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Chhatarpur))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Chhindwara))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Damoh))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Datia))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Dewas))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Dhar))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Dindori))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Guna))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Gwalior))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Harda))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Hoshangabad))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Indore))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Jabalpur))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Jhabua))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Katni))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Khandwa_East_Nimar))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Khargone_West_Nimar))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Mandla))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Mandsaur))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Morena))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Narsimhapur))
                            return list
                        }
                        31->{
                            list.addAll(context.resources.getStringArray(R.array.Neemuch))
                            return list
                        }
                        32->{
                            list.addAll(context.resources.getStringArray(R.array.Panna))
                            return list
                        }
                        33->{
                            list.addAll(context.resources.getStringArray(R.array.Raisen))
                            return list
                        }
                        34->{
                            list.addAll(context.resources.getStringArray(R.array.Rajgarh))
                            return list
                        }
                        35->{
                            list.addAll(context.resources.getStringArray(R.array.Ratlam))
                            return list
                        }
                        36->{
                            list.addAll(context.resources.getStringArray(R.array.Rewa))
                            return list
                        }
                        37->{
                            list.addAll(context.resources.getStringArray(R.array.Sagar))
                            return list
                        }
                        38->{
                            list.addAll(context.resources.getStringArray(R.array.Satna))
                            return list
                        }
                        39->{
                            list.addAll(context.resources.getStringArray(R.array.Sehore))
                            return list
                        }
                        40->{
                            list.addAll(context.resources.getStringArray(R.array.Seoni))
                            return list
                        }
                        41->{
                            list.addAll(context.resources.getStringArray(R.array.Shahdol))
                            return list
                        }
                        42->{
                            list.addAll(context.resources.getStringArray(R.array.Shajapur))
                            return list
                        }
                        43->{
                            list.addAll(context.resources.getStringArray(R.array.Sheopur))
                            return list
                        }
                        44->{
                            list.addAll(context.resources.getStringArray(R.array.Shivpuri))
                            return list
                        }
                        45->{
                            list.addAll(context.resources.getStringArray(R.array.Sidhi))
                            return list
                        }
                        46->{
                            list.addAll(context.resources.getStringArray(R.array.Singrauli))
                            return list
                        }
                        47->{
                            list.addAll(context.resources.getStringArray(R.array.Tikamgarh))
                            return list
                        }
                        48->{
                            list.addAll(context.resources.getStringArray(R.array.Ujjain))
                            return list
                        }
                        49->{
                            list.addAll(context.resources.getStringArray(R.array.Umaria))
                            return list
                        }
                        50->{
                            list.addAll(context.resources.getStringArray(R.array.Vidisha))
                            return list
                        }

                    }
                }
                22->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Ahmadnagar))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Akola))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Amravati))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Aurangabad))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Bhandara))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Bid))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Buldana))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Chandrapur))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Dhule))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Gadchiroli))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Gondiya))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Hingoli))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Jalgaon))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Jalna))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Kolhapur))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Latur))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Mumbai))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Mumbai_Suburban))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Nagpur))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Nanded))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Nandurbar))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Nashik))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Osmanabad))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Parbhani))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Pune))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Raigarh))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Ratnagiri))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Sangli))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Satara))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Sindhudurg))
                            return list
                        }
                        31->{
                            list.addAll(context.resources.getStringArray(R.array.Solapur))
                            return list
                        }
                        32->{
                            list.addAll(context.resources.getStringArray(R.array.Thane))
                            return list
                        }
                        33->{
                            list.addAll(context.resources.getStringArray(R.array.Wardha))
                            return list
                        }
                        34->{
                            list.addAll(context.resources.getStringArray(R.array.Washim))
                            return list
                        }
                        35->{
                            list.addAll(context.resources.getStringArray(R.array.Yavatmal))
                            return list
                        }

                    }
                }
                23->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.MANIPUR1))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Bishnupur))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Chandel))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Churachandpur))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Imphal_East))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Imphal_West))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Senapati))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Tamenglong))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Thoubal))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Ukhrul))
                            return list
                        }

                    }
                }
                24->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.East_Garo_Hills))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.East_Khasi_Hills))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Jaintia_Hills))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Ribhoi))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.South_Garo_Hills))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.West_Garo_Hills))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.West_Khasi_Hills))
                            return list
                        }

                    }
                }
                25->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Aizawl))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Champhai))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Kolasib))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Lawngtlai))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Lunglei))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Mamit))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Saiha))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Serchhip))
                            return list
                        }

                    }
                }
                26->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Dimapur))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Kiphire))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Kohima))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Longleng))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Mokokchung))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Mon))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Peren))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Phek))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Tuensang))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Wokha))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Zunheboto))
                            return list
                        }

                    }
                }
                27->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Anugul))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Balangir))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Baleshwar))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Bargarh))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Baudh))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Bhadrak))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Cuttack))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Debagarh))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Dhenkanal))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Gajapati))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Ganjam))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Jagatsinghapur))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Jajapur))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Jharsuguda))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Kalahandi))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Kandhamal))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Kendrapara))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Kendujhar))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Khordha))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Koraput))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Malkangiri))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Mayurbhanj))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Nabarangapur))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Nayagarh))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Nuapada))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Puri))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Rayagada))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Sambalpur))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Subarnapur))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Sundargarh))
                            return list
                        }

                    }
                }
                28->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.PUDUCHERRY1))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Karaikal))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Mahe))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Yanam))
                            return list
                        }

                    }
                }
                29->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Amritsar))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Barnala))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Bathinda))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Faridkot))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Fatehgarh_Sahib))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Firozpur))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Gurdaspur))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Hoshiarpur))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Jalandhar))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Kapurthala))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Ludhiana))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Mansa))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Moga))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Muktsar))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Patiala))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Rupnagar))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Sahibzada_Ajit_Singh_Nagar))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Sangrur))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Shahid_Bhagat_Singh_Nagar))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Tarn_Taran))
                            return list
                        }

                    }
                }
                30->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Ajmer))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Alwar))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Banswara))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Baran))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Barmer))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Bharatpur))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Bhilwara))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Bikaner))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Bundi))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Chittaurgarh))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Churu))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Dausa))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Dhaulpur))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Dungarpur))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Ganganagar))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Hanumangarh))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Jaipur))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Jaisalmer))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Jalor))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Jhalawar))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Jhunjhunun))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Jodhpur))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Karauli))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Kota))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Nagaur))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Pali))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Pratapgarh1))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Rajsamand))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Sawai_Madhopur))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Sikar))
                            return list
                        }
                        31->{
                            list.addAll(context.resources.getStringArray(R.array.Sirohi))
                            return list
                        }
                        32->{
                            list.addAll(context.resources.getStringArray(R.array.Tonk))
                            return list
                        }
                        33->{
                            list.addAll(context.resources.getStringArray(R.array.Udaipur))
                            return list
                        }

                    }
                }
                31->{
                    when(districtPosition){
                        1->{
                                list.addAll(context.resources.getStringArray(R.array.East_District))
                            return list
                        }
                        2->{
                                list.addAll(context.resources.getStringArray(R.array.North_District))
                            return list
                        }
                        3->{
                                list.addAll(context.resources.getStringArray(R.array.South_District))
                            return list
                        }
                        4->{
                                list.addAll(context.resources.getStringArray(R.array.West_District))
                            return list
                        }

                    }
                }
                32->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Ariyalur))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Chennai))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Coimbatore))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Cuddalore))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Dharmapuri))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Dindigul))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Erode))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Kancheepuram))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Kanniyakumari))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Karur))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Krishnagiri))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Madurai))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Nagapattinam))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Namakkal))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Perambalur))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Pudukkottai))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Ramanathapuram))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Salem))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Sivaganga))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Thanjavur))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.The_Nilgiris))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Theni))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Thiruvallur))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Thiruvarur))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Thoothukkudi))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Tiruchirappalli))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Tirunelveli))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Tiruppur))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Tiruvannamalai))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Vellore))
                            return list
                        }
                        31->{
                            list.addAll(context.resources.getStringArray(R.array.Viluppuram))
                            return list
                        }
                        32->{
                            list.addAll(context.resources.getStringArray(R.array.Virudhunagar))
                            return list
                        }

                    }
                }
                33->{
                    when(districtPosition){

                    }
                }
                34->{
                    when(districtPosition){

                    }
                }
                35->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Dhalai))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.North_Tripura))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.South_Tripura))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.West_Tripura))
                            return list
                        }

                    }
                }
                36->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Agra))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Aligarh))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Allahabad))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Ambedkar_Nagar))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Auraiya))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Azamgarh))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Baghpat))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Bahraich))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Ballia))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Balrampur))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Banda))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Bara_Banki))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Bareilly))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.Basti))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Bijnor))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Budaun))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Bulandshahr))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.Chandauli))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Chitrakoot))
                            return list
                        }
                        20->{
                            list.addAll(context.resources.getStringArray(R.array.Deoria))
                            return list
                        }
                        21->{
                            list.addAll(context.resources.getStringArray(R.array.Etah))
                            return list
                        }
                        22->{
                            list.addAll(context.resources.getStringArray(R.array.Etawah))
                            return list
                        }
                        23->{
                            list.addAll(context.resources.getStringArray(R.array.Faizabad))
                            return list
                        }
                        24->{
                            list.addAll(context.resources.getStringArray(R.array.Farrukhabad))
                            return list
                        }
                        25->{
                            list.addAll(context.resources.getStringArray(R.array.Fatehpur))
                            return list
                        }
                        26->{
                            list.addAll(context.resources.getStringArray(R.array.Firozabad))
                            return list
                        }
                        27->{
                            list.addAll(context.resources.getStringArray(R.array.Gautam_Buddha_Nagar))
                            return list
                        }
                        28->{
                            list.addAll(context.resources.getStringArray(R.array.Ghaziabad))
                            return list
                        }
                        29->{
                            list.addAll(context.resources.getStringArray(R.array.Ghazipur))
                            return list
                        }
                        30->{
                            list.addAll(context.resources.getStringArray(R.array.Gonda))
                            return list
                        }
                        31->{
                            list.addAll(context.resources.getStringArray(R.array.Gorakhpur))
                            return list
                        }
                        32->{
                            list.addAll(context.resources.getStringArray(R.array.Hamirpur))
                            return list
                        }
                        33->{
                            list.addAll(context.resources.getStringArray(R.array.Hardoi))
                            return list
                        }
                        34->{
                            list.addAll(context.resources.getStringArray(R.array.Jalaun))
                            return list
                        }
                        35->{
                            list.addAll(context.resources.getStringArray(R.array.Jaunpur))
                            return list
                        }
                        36->{
                            list.addAll(context.resources.getStringArray(R.array.Jhansi))
                            return list
                        }
                        37->{
                            list.addAll(context.resources.getStringArray(R.array.Jyotiba_Phule_Nagar))
                            return list
                        }
                        38->{
                            list.addAll(context.resources.getStringArray(R.array.Kannauj))
                            return list
                        }
                        39->{
                            list.addAll(context.resources.getStringArray(R.array.Kanpur_Dehat))
                            return list
                        }
                        40->{
                            list.addAll(context.resources.getStringArray(R.array.Kanpur_Nagar))
                            return list
                        }
                        41->{
                            list.addAll(context.resources.getStringArray(R.array.Kanshiram_Nagar))
                            return list
                        }
                        42->{
                            list.addAll(context.resources.getStringArray(R.array.Kaushambi))
                            return list
                        }
                        43->{
                            list.addAll(context.resources.getStringArray(R.array.Kheri))
                            return list
                        }
                        44->{
                            list.addAll(context.resources.getStringArray(R.array.Kushinagar))
                            return list
                        }
                        45->{
                            list.addAll(context.resources.getStringArray(R.array.Lalitpur))
                            return list
                        }
                        46->{
                            list.addAll(context.resources.getStringArray(R.array.Lucknow))
                            return list
                        }
                        47->{
                            list.addAll(context.resources.getStringArray(R.array.Mahamaya_Nagar))
                            return list
                        }
                        48->{
                            list.addAll(context.resources.getStringArray(R.array.Mahoba))
                            return list
                        }
                        49->{
                            list.addAll(context.resources.getStringArray(R.array.Mahrajganj))
                            return list
                        }
                        50->{
                            list.addAll(context.resources.getStringArray(R.array.Mainpuri))
                            return list
                        }
                        51->{
                            list.addAll(context.resources.getStringArray(R.array.Mathura))
                            return list
                        }
                        52->{
                            list.addAll(context.resources.getStringArray(R.array.Mau))
                            return list
                        }
                        53->{
                            list.addAll(context.resources.getStringArray(R.array.Meerut))
                            return list
                        }
                        54->{
                            list.addAll(context.resources.getStringArray(R.array.Mirzapur))
                            return list
                        }
                        55->{
                            list.addAll(context.resources.getStringArray(R.array.Moradabad))
                            return list
                        }
                        56->{
                            list.addAll(context.resources.getStringArray(R.array.Muzaffarnagar))
                            return list
                        }
                        57->{
                            list.addAll(context.resources.getStringArray(R.array.Pilibhit))
                            return list
                        }
                        58->{
                            list.addAll(context.resources.getStringArray(R.array.Pratapgarh))
                            return list
                        }
                        59->{
                            list.addAll(context.resources.getStringArray(R.array.Rae_Bareli))
                            return list
                        }
                        60->{
                            list.addAll(context.resources.getStringArray(R.array.Rampur))
                            return list
                        }
                        61->{
                            list.addAll(context.resources.getStringArray(R.array.Saharanpur))
                            return list
                        }
                        62->{
                            list.addAll(context.resources.getStringArray(R.array.Sant_Kabir_Nagar))
                            return list
                        }
                        63->{
                            list.addAll(context.resources.getStringArray(R.array.Sant_Ravidas_Nagar_Bhadohi))
                            return list
                        }
                        64->{
                            list.addAll(context.resources.getStringArray(R.array.Shahjahanpur))
                            return list
                        }
                        65->{
                            list.addAll(context.resources.getStringArray(R.array.Shrawasti))
                            return list
                        }
                        66->{
                            list.addAll(context.resources.getStringArray(R.array.Siddharthnagar))
                            return list
                        }
                        67->{
                            list.addAll(context.resources.getStringArray(R.array.Sitapur))
                            return list
                        }
                        68->{
                            list.addAll(context.resources.getStringArray(R.array.Sonbhadra))
                            return list
                        }
                        69->{
                            list.addAll(context.resources.getStringArray(R.array.Sultanpur))
                            return list
                        }
                        70->{
                            list.addAll(context.resources.getStringArray(R.array.Unnao))
                            return list
                        }
                        71->{
                            list.addAll(context.resources.getStringArray(R.array.Varanasi))
                            return list
                        }

                    }
                }
                37->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Almora))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Bageshwar))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Chamoli))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Champawat))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Dehradun))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Garhwal))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Hardwar))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Nainital))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Pithoragarh))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Rudraprayag))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Tehri_Garhwal))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Udham_Singh_Nagar))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Uttarkashi))
                            return list
                        }

                    }
                }
                38->{
                    when(districtPosition){
                        1->{
                            list.addAll(context.resources.getStringArray(R.array.Bankura))
                            return list
                        }
                        2->{
                            list.addAll(context.resources.getStringArray(R.array.Barddhaman))
                            return list
                        }
                        3->{
                            list.addAll(context.resources.getStringArray(R.array.Birbhum))
                            return list
                        }
                        4->{
                            list.addAll(context.resources.getStringArray(R.array.Dakshin_Dinajpur))
                            return list
                        }
                        5->{
                            list.addAll(context.resources.getStringArray(R.array.Darjiling))
                            return list
                        }
                        6->{
                            list.addAll(context.resources.getStringArray(R.array.Haora))
                            return list
                        }
                        7->{
                            list.addAll(context.resources.getStringArray(R.array.Hugli))
                            return list
                        }
                        8->{
                            list.addAll(context.resources.getStringArray(R.array.Jalpaiguri))
                            return list
                        }
                        9->{
                            list.addAll(context.resources.getStringArray(R.array.Koch_Bihar))
                            return list
                        }
                        10->{
                            list.addAll(context.resources.getStringArray(R.array.Kolkata))
                            return list
                        }
                        11->{
                            list.addAll(context.resources.getStringArray(R.array.Maldah))
                            return list
                        }
                        12->{
                            list.addAll(context.resources.getStringArray(R.array.Murshidabad))
                            return list
                        }
                        13->{
                            list.addAll(context.resources.getStringArray(R.array.Nadia))
                            return list
                        }
                        14->{
                            list.addAll(context.resources.getStringArray(R.array.North_Twenty_Four_Parganas))
                            return list
                        }
                        15->{
                            list.addAll(context.resources.getStringArray(R.array.Paschim_Medinipur))
                            return list
                        }
                        16->{
                            list.addAll(context.resources.getStringArray(R.array.Purba_Medinipur))
                            return list
                        }
                        17->{
                            list.addAll(context.resources.getStringArray(R.array.Puruliya))
                            return list
                        }
                        18->{
                            list.addAll(context.resources.getStringArray(R.array.South_Twenty_Four_Parganas))
                            return list
                        }
                        19->{
                            list.addAll(context.resources.getStringArray(R.array.Uttar_Dinajpur))
                            return list
                        }

                    }
                }


                else ->{
                    return mutableListOf(cityDefaultItem)
                }

            }
            return mutableListOf(cityDefaultItem)
        }

        fun getBlock(position : Int):MutableList<String>{
            return blockList[position]
        }

        fun getVillage(position : Int):MutableList<String>{
            return villageList[position]
        }

    }


}