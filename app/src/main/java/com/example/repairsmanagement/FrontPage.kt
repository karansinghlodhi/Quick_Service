package com.example.repairsmanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.repairsmanagement.staticdata.StaticData
import com.google.firebase.auth.FirebaseAuth

class FrontPage : AppCompatActivity() {
    private lateinit var  user : Button
    private lateinit var  worker : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_page)
        user = findViewById(R.id.user)
        worker = findViewById(R.id.worker)
        StaticData.setData(this)

        if(FirebaseAuth.getInstance().currentUser!=null)
            startActivity(Intent(this,MainActivity::class.java))

        user.setOnClickListener {

            startActivity(Intent(this,MainActivity::class.java))
        }
        worker.setOnClickListener {


            startActivity(Intent(this,LoginPage::class.java))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        moveTaskToBack(true)
    }
}