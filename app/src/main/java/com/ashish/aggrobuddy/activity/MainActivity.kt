package com.ashish.aggrobuddy.activity;

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ashish.aggrobuddy.*
import com.ashish.aggrobuddy.fragment.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    var titleName: String? ="person"
    lateinit var sharedPreferences:SharedPreferences

    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView


    var previousMenuItem:MenuItem?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences("Aggrobuddy preference",Context.MODE_PRIVATE)

        setContentView(R.layout.activity_main)
            titleName=sharedPreferences.getString("nameOfPersonLogin","nameOfPersonLogin")
        title=titleName

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
       toolbar = findViewById(R.id.toolbar)
        frameLayout = findViewById(R.id.frame)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity,
                drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            if (previousMenuItem != null)
            {
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it

            when(it.itemId)
            {
                R.id.dashboard -> {
                   openDashboard()
                    drawerLayout.closeDrawers()

                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MyAccountFragment())

                        .commit()
                    supportActionBar?.title="Profile"
                    drawerLayout.closeDrawers()

                }
                R.id.favourites -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, FavouritesFragment())

                        .commit()
                    supportActionBar?.title="Favourites"
                    drawerLayout.closeDrawers()


                }
                R.id.Cart -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MyCartFragment())

                        .commit()
                    supportActionBar?.title="My Cart"
                    drawerLayout.closeDrawers()


                }
                R.id.TransactionHistory -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, TransactionHistoryFragment())

                        .commit()
                    supportActionBar?.title="Transaction History"
                    drawerLayout.closeDrawers()


                }
                R.id.FrequentAskQuestion -> {

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame,FrequentlyAskedQuestion())
                        .commit()

                    supportActionBar?.title="FAQs"
                    drawerLayout.closeDrawers()


                }
                R.id.developer -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, DevelopersFragment())

                        .commit()
                    supportActionBar?.title="Developers"
                    drawerLayout.closeDrawers()


                }
                R.id.Send_Feedback -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, SendFeedBackFragment())

                        .commit()
                    supportActionBar?.title="Send Feedback"
                    drawerLayout.closeDrawers()


                }
                R.id.PrivacyPolicy -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, PrivacyPolicyFragment())

                        .commit()
                    supportActionBar?.title="Privacy Policy"
                    drawerLayout.closeDrawers()

                }
                R.id.AboutApp -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AboutAppFragment())

                        .commit()
                    supportActionBar?.title="About App"
                    drawerLayout.closeDrawers()

                }

                R.id.LogOut -> {
                    drawerLayout.closeDrawers()
                    val dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("Confirmation")
                    dialog.setMessage("Are you ready to Logout ?!!!!!")
                    dialog.setPositiveButton("Yes, Log out")
                    {
                        _, _->
                        val editor:SharedPreferences.Editor=sharedPreferences.edit()
                        editor.clear()
                        editor.apply()
                        /*DeleteFavourites(this@MainActivity).execute()
                        val intentToLoginActivity = Intent (this@MainActivity,LoginActivity::class.java)
                        startActivity(intentToLoginActivity)*/
                        finish()

                    }
                    dialog.setNegativeButton("Never Mind ",null)
                    dialog.create().show()

                }

                R.id.HelpCenter -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, HelpFragment())

                        .commit()
                    supportActionBar?.title="Help Center"
                    drawerLayout.closeDrawers()

                }
            }
            return@setNavigationItemSelectedListener true
        }

    }

    class DeleteFavourites(val context : Context) {

    }

    fun setUpToolbar() {

        setSupportActionBar(toolbar)
        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    fun openDashboard()
    {
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.commit()
        supportActionBar?.title="Dashboard"
        navigationView.setCheckedItem(R.id.dashboard)
    }

    override fun onBackPressed() {
        val frag= supportFragmentManager.findFragmentById(R.id.frame)
        when (frag)
        {
          !is DashboardFragment ->openDashboard()
          else->super.onBackPressed()
        }

    }



}