package com.example.repairsmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class HelpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_page)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //       addData.setOnClickListener {
//            val databaseRefe= FirebaseDatabase.getInstance().getReference()
//            databaseRefe.child("UserPersonalData").addListenerForSingleValueEvent(object : ValueEventListener{
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    for ( snap in snapshot.children){
//                        snap.ref.removeValue()
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//
//                }
//
//            })
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}