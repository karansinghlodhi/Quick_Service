package com.example.repairsmanagement

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import com.example.repairsmanagement.data.ApplicationUser
import com.example.repairsmanagement.staticdata.StaticData
import com.example.repairsmanagement.utilityClasses.BackgroundTask
import com.example.repairsmanagement.utilityClasses.ProgressTask
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login_page.*
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

class LoginPage : AppCompatActivity() {

    lateinit var handler:android.os.Handler
    lateinit var run :Runnable
    lateinit var  mnumber : EditText
    lateinit var auth : FirebaseAuth
    lateinit var database: DatabaseReference
    lateinit var personalDatabase: DatabaseReference
    var storedVerificationId = ""
    //lateinit var progressDialog:ProgressDialog
    lateinit var progressDialog : ProgressTask
    var isNetworkAvailable = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
//        progressDialog = ProgressDialog(this)
//        progressDialog.setCancelable(false)
//        progressDialog.setTitle("Login Please Wait")
        handler = Handler(Looper.getMainLooper())
        run = object : Runnable{
            override fun run() {
                Log.i("isnetworkavailable","${isNetworkConnected()}")
                if (isNetworkConnected())
                    loginCurrentUser()
                handler.postDelayed(this,1000)
            }

        }

        back_button.setOnClickListener {
            startActivity(Intent(this,FrontPage::class.java))
        }

        StaticData.setData(this)

        mnumber=findViewById(R.id.monumber)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance().getReference("ApplicationUser")
        personalDatabase = FirebaseDatabase.getInstance().getReference("UserPersonalData")


    }

    private fun isPersonalDataAvailable(currentUser:FirebaseUser?):Boolean{
        var flag = false
        database.child(currentUser!!.uid).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val temp = snapshot.getValue(ApplicationUser::class.java)
                if(temp!=null){
                    flag = temp.detailsAvailable
                    //toastMessage("flag value : $flag")
                }
                if(flag) {
                    pageMain()
                }
                else
                    pagePersonal()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        return flag
    }

    private fun pageMain() {
        toastMessage("Login successfully")
        progressDialog.dismiss()
        startActivity(Intent(this,MainActivity::class.java))
    }
    private fun pagePersonal() {
        toastMessage("Login successfully")
        progressDialog.dismiss()
        startActivity(Intent(this,PersonalDataPage::class.java))
    }

    private fun toastMessage(message:String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        progressDialog = ProgressTask(this)

        //toastMessage("isnetworkconnected"+isNetworkConnected().toString())

    ok.setOnClickListener {
        val otp = enter_otp.text.toString()
        if (otp.isNotEmpty() && storedVerificationId.isNotEmpty()){


        }
    }

        if (isNetworkConnected()) {

            val currentUser = FirebaseAuth.getInstance().currentUser
            if (currentUser != null) {
                progressDialog.show()
                Log.i("in ","lognin")
                isPersonalDataAvailable(currentUser)

            }
        } else {
            //handler.post(run)
//            if (progressDialog.isShowing)
//                progressDialog.dismiss()
            progressDialog.dismiss()
            toastMessage("network is not Available")
        }


        get_otp.setOnClickListener {
            //Toast.makeText(this,"${mnumber.text}",Toast.LENGTH_LONG).show()
            //handler.removeCallbacks(run)
            if(isNetworkConnected()){
                loginCurrentUser()
                if(validateform()){
                    welcome.isVisible=true
                    authUserByMobile("+91"+mnumber.text.toString())
                }
            }else
                toastMessage("network is not available")
        }

    }

    private fun validateform(): Boolean {
        val flag = false
        if (Pattern.matches("[0-9]{0,9}",mnumber.text)){
            mnumber.error = "Please Enter valid number"

        }else if (mnumber.text.length!=10){
            mnumber.error = "Please enter 10 digit mobile number"
        }
        else
            return true
        return flag
    }

    fun authUserByMobile(phoneNumber:String){
        val backgroundTask = BackgroundTask()
        backgroundTask.backgroundTask(30,get_otp)


        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                // This callback will be invoked in two situations:
                // 1 - Instant verification. In some cases the phone number can be instantly
                //     verified without needing to send or enter a verification code.
                // 2 - Auto-retrieval. On some devices Google Play services can automatically
                //     detect the incoming verification SMS and perform verification without
                //     user action.
                Log.d("TAG", "onVerificationCompleted:$credential")
                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                // This callback is invoked in an invalid request for verification is made,
                // for instance if the the phone number format is not valid.
                Log.w("TAG", "onVerificationFailed", e)


                if (e is FirebaseAuthInvalidCredentialsException) {
                    // Invalid request
                    // ...
                } else if (e is FirebaseTooManyRequestsException) {
                    // The SMS quota for the project has been exceeded
                    // ...
                    toastMessage("too many OTP : try after some time")

                }
                //get_otp.isClickable=true

                // Show a message and update the UI
                // ...
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                // The SMS verification code has been sent to the provided phone number, we
                // now need to ask the user to enter the code and then construct a credential
                // by combining the code with a verification ID.
                Log.d("TAG", "onCodeSent:$verificationId")

                // Save verification ID and resending token so we can use them later
                storedVerificationId = verificationId
                val resendToken = token

                // ...
            }
        }

        ok.setOnClickListener {
            val otp = enter_otp.text.toString()
            if (otp.isNotEmpty() && storedVerificationId.isNotEmpty()){
                val credential = PhoneAuthProvider.getCredential(storedVerificationId,otp)
                callbacks.onVerificationCompleted(credential)

            }
        }

//        val credential = PhoneAuthProvider.getCredential(storedVerificationId, )

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber, // Phone number to verify
            30, // Timeout duration
            TimeUnit.SECONDS, // Unit of timeout
            this, // Activity (for callback binding)
            callbacks) // OnVerificationStateChangedCallbacks



    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        Log.i("crads","$credential")
        //Toast.makeText(this,"successfully Reached : $credential",Toast.LENGTH_LONG).show()

        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("SIGN In", "signInWithCredential:success")

                    val user = task.result?.user
                    checkUserDataExist(user)
                    //Toast.makeText(this,"firebaseUser:Sign in Successfully",Toast.LENGTH_LONG).show()
                    // ...
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                    }
                }
                get_otp.isClickable=true;
                welcome.isVisible=false
            }
        Log.i("UID","${auth.currentUser?.uid}")
    }
    fun checkUserDataExist(user: FirebaseUser?){
        personalDatabase.addListenerForSingleValueEvent(
            object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val flag = snapshot.hasChild(user!!.uid)
                    if(!flag){
                        database.child(user.uid).setValue(ApplicationUser(user.uid,mnumber.text.toString(),false))
                        pagePersonal()
                    }
                    else
                        pageMain()

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }

        )
    }

    fun isNetworkConnected():Boolean {
        var flag :Boolean = false
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if(networkInfo!=null)
        flag = networkInfo.isConnected
        return flag
    }

    fun loginCurrentUser(){
        val currentUser = FirebaseAuth.getInstance().currentUser
        //Log.i("method","loin")
//        handler.removeCallbacks(run)
        if (currentUser != null) {
            progressDialog.show()
            //Log.i("in ","lognin")
            isPersonalDataAvailable(currentUser)

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,FrontPage::class.java))
        
    }

//    override fun onRestart() {
//        super.onRestart()
//        toastMessage("restart")
//        Log.i("restart","")
//    }
//
//    override fun recreate() {
//        super.recreate()
//        toastMessage("recreate")
//        Log.i("recreate","")
//    }

//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//
//        progressDialog = ProgressTask(this)
//    }

}