package com.example.repairsmanagement.utilityClasses

import android.content.Context
import android.os.Looper
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData

class BackgroundTask {
    lateinit var handler:android.os.Handler
    lateinit var run :Runnable
    lateinit var handler1:android.os.Handler
    lateinit var run1 :Runnable
    var count:Int=0

    fun backgroundTask(number:Int,otpButton:Button){
        //view.isClickable=false
        otpButton.isClickable=false
        count=number
        handler = android.os.Handler(Looper.getMainLooper())
        run = object : Runnable{
            override fun run() {
                count--
                otpButton.text = "GET OTP Again in $count"
                //view.text="$count"
                handler.postDelayed(this,1000)
                if(count==0)
                    stop(otpButton)
                Log.i("otp","$count")

            }


        }
        handler.post(run)



    }
    fun stop(otpButton: Button){
        Log.i("backgroundtask ","stop")
        handler.removeCallbacks(run)
        //view.isClickable=true
        otpButton.isClickable=true
        otpButton.text = "GET OTP"
    }

    fun backgroundTaskforNetwork(data:MutableLiveData<String>){
        handler = android.os.Handler(Looper.getMainLooper())
        run = object : Runnable{
            override fun run() {

            }
        }
        handler.post(run)
    }
}