package com.example.repairsmanagement

import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.repairsmanagement.data.PersonalData
import com.example.repairsmanagement.ui.home.HomeViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    companion object

    var username = MutableLiveData<String>()

    private lateinit var appBarConfiguration: AppBarConfiguration
    val databaseReference = FirebaseDatabase.getInstance().getReference("UserPersonalData")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        username.value = "User"
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val headerView = navView.getHeaderView(0)
        val usernameField = headerView.findViewById<TextView>(R.id.dusername)
        var user = ""
        val register = navView.menu.findItem(R.id.nav_login_details)
        val editDetails = navView.menu.findItem(R.id.nav_edit_details)
        if (FirebaseAuth.getInstance().currentUser != null)
            user = FirebaseAuth.getInstance().currentUser!!.uid
        if (user.isEmpty()) {
            editDetails.isVisible = false
            register.setOnMenuItemClickListener { item ->
                startActivity(Intent(this, LoginPage::class.java))
                true

            }
        } else {
            register.isVisible = false
        }
        if (user.isNotEmpty())
            databaseReference.child(FirebaseAuth.getInstance().currentUser!!.uid)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val data = snapshot.getValue(PersonalData::class.java)
                        if (data != null)
                            username.value = data.fullname
                    }

                    override fun onCancelled(error: DatabaseError) {

                    }

                })
        username.observe(this, Observer {
            Log.i("mutablelivedata", "$it")
            usernameField.text = it
        })
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_edit_details, R.id.nav_home, R.id.nav_contact_us),
            drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        if (FirebaseAuth.getInstance().currentUser == null)
            menu.findItem(R.id.action_logout).isVisible = false
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            if (isNetworkConnected()) {
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, FrontPage::class.java))
                Toast.makeText(this, "Logout successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Network is not available", Toast.LENGTH_SHORT).show()
            }
        }
        if (item.itemId == R.id.share) {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.setType("text/plain")
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Repairs Management")
                var shareMessage = "\nLet me recommend you this application\n\n"
                shareMessage =
                    """
                ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))

            } catch (e: Exception) {
                Toast.makeText(this, "unable to share application", Toast.LENGTH_SHORT).show()
            }
        }
        if (item.itemId == R.id.help)
            startActivity(Intent(this, HelpPage::class.java))

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun isNetworkConnected(): Boolean {
        var flag: Boolean = false
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if (networkInfo != null)
            flag = networkInfo.isConnected
        return flag
    }

}