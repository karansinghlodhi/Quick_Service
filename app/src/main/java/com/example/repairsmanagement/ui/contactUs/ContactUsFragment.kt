package com.example.repairsmanagement.ui.contactUs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.repairsmanagement.R
import com.google.firebase.database.*

class ContactUsFragment : Fragment() {

    private lateinit var contactUsViewModel: ContactUsViewModel
    private var databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("DummayData")

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactUsViewModel =
                ViewModelProvider(this).get(ContactUsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contact_us, container, false)
//        val visionframe = root.findViewById<LinearLayout>(R.id.vision_frame)
//        val missionframe = root.findViewById<LinearLayout>(R.id.mission_frame)
        val contactUsframe = root.findViewById<LinearLayout>(R.id.contact_us_frame)
        val instagram = root.findViewById<ImageView>(R.id.instagram)
        val facebook = root.findViewById<ImageView>(R.id.facebook)
        val youtube = root.findViewById<ImageView>(R.id.youtube)

        instagram.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/quick_service_app")))

        }
        facebook.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Quick-Service-101655015098615")))

        }
        youtube.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCfpe5hN4pLrp3ZBn3B0vQzQ?view_as=subscriber")))

        }

//        val visionHeader = visionframe.findViewById<TextView>(R.id.header)
//        val visionText = visionframe.findViewById<TextView>(R.id.header_text)
//        val missionHeader = missionframe.findViewById<TextView>(R.id.header)
//        val missionText = missionframe.findViewById<TextView>(R.id.header_text)
        val contactUsHeader = contactUsframe.findViewById<TextView>(R.id.header)
        val contactUsText = contactUsframe.findViewById<TextView>(R.id.header_text)

//        visionHeader.text = resources.getString(R.string.vision)
//        visionText.text = resources.getString(R.string.contact_vision)
//        missionHeader.text = resources.getString(R.string.mission)
//        missionText.text = resources.getString(R.string.contact_mission)
        contactUsHeader.text = resources.getString(R.string.contact_us)
        contactUsText.text = resources.getString(R.string.contact_data)
        return root
    }
}